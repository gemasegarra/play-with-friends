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
  name = '';

  constructor(private gameList: GamesService) {}

  ngOnInit(): void {
    this.gameList.getGames().subscribe((dataResult) => {
      this.games = dataResult;
    });
  }

  searchTitle(event: Event): void {
    this.gameList.findByName(this.name).subscribe(
      (data) => {
        this.games = data;
      },
      (error) => {
        console.log(error);
      }
    );
  }

  filterByType(type: any): void {
    this.gameList.findByType(type).subscribe(
      (data) => {
        this.games = data;
      },
      (error) => {
        console.log(error);
      }
    );
  }
  addToOwnedGames(id: number): void {
  }
}
