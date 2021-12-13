import { Component, OnInit } from '@angular/core';
import { MatchingService } from 'src/app/services/matching.service';
import { MatchingOutput } from '../../model/MatchingOutput';

@Component({
  selector: 'app-matching-request-list',
  templateUrl: './matching-request-list.component.html',
  styleUrls: ['./matching-request-list.component.css']
})
export class MatchingRequestListComponent implements OnInit {
  matches: Array<MatchingOutput> = [];

  constructor(private matchList: MatchingService) {}

  ngOnInit(): void {
    this.matchList.getMatches().subscribe((dataResult) => {
      this.matches = dataResult;
    });
  }
}
