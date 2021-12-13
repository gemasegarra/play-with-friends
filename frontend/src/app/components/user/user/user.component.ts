import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MatchingService } from 'src/app/services/matching.service';
import { UserService } from 'src/app/services/user.service';
import { MatchingOutput } from '../../model/MatchingOutput';
import { UserProfile } from '../../model/UserProfile';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  user!: UserProfile;
  id!: any;
  matchesCreated: Array<MatchingOutput> = [];
  matchesJoined: Array<MatchingOutput> = [];
  panelOpenState!: boolean;

  constructor(
    private showUser: UserService,
    private route: ActivatedRoute,
    private matchService: MatchingService
  ) {}

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.showUser.getUser(this.id).subscribe((dataResult) => {
      this.user = dataResult;
    });
    this.findMatchRequests();
    this.findMatchRequestsJoined();
  }

  findMatchRequests(): void {
    this.matchService.getMatchByUser(this.id).subscribe((data) => {
      this.matchesCreated = data;
    });
  }
  findMatchRequestsJoined(): void {
    this.matchService.getMatchByMatcher(this.id).subscribe((data) => {
      this.matchesJoined = data;
    });
  }
}
