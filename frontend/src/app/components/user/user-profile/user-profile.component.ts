import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { connectableObservableDescriptor } from 'rxjs/internal/observable/ConnectableObservable';
import { MatchingService } from 'src/app/services/matching.service';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';
import { MatchingOutput } from '../../model/MatchingOutput';
import { UserProfile } from '../../model/UserProfile';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  username: any;
  userId!: any;
  user!: UserProfile;
  matchId!: any;
  matchesCreated: Array<MatchingOutput> = [];
  matchesJoined: Array<MatchingOutput> = [];
  panelOpenState!: boolean;

  constructor(
    private userService: UserService,
    private matchService: MatchingService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.username = localStorage.getItem('user');
    this.findUserId();

  }

  findUserId(): void {
    this.userService.findUserIdByName(this.username).subscribe((data) => {
      this.userId = data;
      this.findUser();
    });
  }

  findUser(): void {
    this.userService.getUser(this.userId).subscribe((data) => {
      this.user = data;
    });
  }

  findMatchRequests(): void {
    this.matchService.getMatchByUser(this.user.username).subscribe((data) => {
      this.matchesCreated = data;
      console.log(data)
    });
  }
  findMatchRequestsJoined(): void {
    this.matchService
      .getMatchByMatcher(this.user.username)
      .subscribe((data) => {
        this.matchesJoined = data;

      });
  }

  deleteAlert(id: number): void {
    Swal.fire({
      title: 'Are you sure you want to delete this match request?',
      showDenyButton: true,
      confirmButtonText: 'Cancel',
      denyButtonText: 'Yes! Delete it!'
    }).then((result) => {
      if (result.isDenied) {
        Swal.fire('Match deleted!', '', 'success');
        this.deleteMatch(id);
        this.router.navigate(['/matchinglist']);
        this.reloadPage();
      }
    });
  }

  deleteMatch(id: number): void {
    this.matchService.deleteMatch(id).subscribe(() => {
      console.log('match deleted');
    });
  }

  reloadPage() {
    setTimeout(() => {
      window.location.reload();
    }, 100);
  }
}
