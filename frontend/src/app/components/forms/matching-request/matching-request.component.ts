import { Component, OnInit } from '@angular/core';
import { GamesService } from 'src/app/services/games.service';
import { Game } from '../../model/Game';

@Component({
  selector: 'app-matching-request',
  templateUrl: './matching-request.component.html',
  styleUrls: ['./matching-request.component.css']
})
export class MatchingRequestComponent implements OnInit {

  games: Array<Game> = [];

  constructor(
    private gameList: GamesService

  ) { }

  ngOnInit(): void {
    this.gameList.getGames().subscribe(dataResult => {
      this.games = dataResult;
  });
}


}
