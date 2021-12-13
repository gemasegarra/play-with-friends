import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { catchError } from 'rxjs/operators';
import { GamesService } from 'src/app/services/games.service';
import { MatchingService } from 'src/app/services/matching.service';
import Swal from 'sweetalert2';
import { Game } from '../../model/Game';
import { MatchingRequest } from '../../model/MatchingRequest';

@Component({
  selector: 'app-matching-request',
  templateUrl: './matching-request.component.html',
  styleUrls: ['./matching-request.component.css']
})
export class MatchingRequestComponent implements OnInit {
  registerForm: FormGroup;
  games: Array<Game> = [];
  numberOfPlayerInput: FormControl;
  gameInput: FormControl;
  commentInput: FormControl;
  matches!: [];
  matchRequest!: MatchingRequest;
  errorMessage!: string;
  errorStatus!: number;
  username: any;

  constructor(
    private gameList: GamesService,
    private matchingRequest: MatchingService,
    private router: Router
  ) {
    this.numberOfPlayerInput = new FormControl('', [Validators.required]);
    this.gameInput = new FormControl('', [Validators.required]);
    this.commentInput = new FormControl('', [Validators.required]);
    this.username = localStorage.getItem('user');
    this.registerForm = new FormGroup({
      numberOfPlayer: this.numberOfPlayerInput,
      game: this.gameInput,
      comment: this.commentInput
    });
  }

  ngOnInit(): void {
    this.gameList.getGames().subscribe((dataResult) => {
      this.games = dataResult;
    });
  }

  createMatch(): void {
    this.matchRequest = new MatchingRequest(
      this.gameInput.value,
      this.username,
      this.numberOfPlayerInput.value,
      this.commentInput.value,
      this.matches
    );
    this.matchingRequest
      .createMatch(this.matchRequest)
      .pipe(
        catchError((err: HttpErrorResponse) => {
          this.errorMessage = err.error.message;
          this.errorStatus = err.error.status;
          this.errorAlert();
          throw new Error('error');
        })
      )
      .subscribe((matchRequest) => {
        this.alertWithSuccess();
        this.router.navigate(['/matchinglist']);
      });
  }

  onSubmit(): void {
    this.createMatch();
  }

  errorAlert() {
    Swal.fire({
      icon: 'error',
      title: 'Matching request creation failed',
      text: this.errorMessage
    });
  }

  alertWithSuccess() {
    Swal.fire({
      title: 'Match request created!',
      icon: 'success',
      showConfirmButton: false,
      timer: 1500
    });
  }
}
