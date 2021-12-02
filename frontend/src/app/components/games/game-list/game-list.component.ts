import { Component, OnInit } from '@angular/core';
import { GamesService } from 'src/app/services/games.service';
import { Game } from '../../model/Game';

@Component({
  selector: 'app-game-list',
  templateUrl: './game-list.component.html',
  styleUrls: ['./game-list.component.css']
})
export class GameListComponent implements OnInit {

  games: Array<Game> = [];

  constructor(
    private gameList: GamesService
  ) { }

  ngOnInit(): void {
    this.gameList.getGames().subscribe(dataResult => {
      this.games = dataResult;
      console.log(dataResult)
  });
}
}
  
