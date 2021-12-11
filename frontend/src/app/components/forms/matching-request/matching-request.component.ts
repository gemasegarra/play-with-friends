import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { catchError } from 'rxjs/operators';
import { GamesService } from 'src/app/services/games.service';
import { MatchingService } from 'src/app/services/matching.service';
import Swal from 'sweetalert2';
import { Game } from '../../model/Game';
import { Matching } from '../../model/Matching';

@Component({
  selector: 'app-matching-request',
  templateUrl: './matching-request.component.html',
  styleUrls: ['./matching-request.component.css']
})
export class MatchingRequestComponent implements OnInit {

  registerForm: FormGroup;
  games: Array<Game> = [];
  userInput: FormControl;
  numberOfPlayerInput: FormControl;
  gameInput: FormControl;
  commentInput: FormControl;
  matchRequest!: Matching;
  errorMessage!: string;
  errorStatus!: number;

  constructor(
    private gameList: GamesService,
    private matchingRequest: MatchingService,
    private router: Router
  ) {  
    this.userInput = new FormControl('', [ Validators.required]);
    this.numberOfPlayerInput = new FormControl('', [Validators.required]);
    this.gameInput = new FormControl('', [Validators.required]);
    this.commentInput = new FormControl('', [Validators.required]);

    this.registerForm = new FormGroup({
      user: this.userInput,
      numberOfPlayer: this.numberOfPlayerInput,
      game: this.gameInput,
      comment: this.commentInput
  });}

  ngOnInit(): void {
    this.gameList.getGames().subscribe(dataResult => {
      this.games = dataResult;
  });
}

  createMatch(): void {
    // necesito el id del juego 
    this.matchRequest = new Matching(this.gameInput.value, this.userInput.value, this.numberOfPlayerInput.value, this.commentInput.value);
    console.log(this.matchRequest)
    this.matchingRequest.createMatch(this.matchRequest)
      .pipe(catchError((err: HttpErrorResponse) => {
        this.errorMessage = err.error.message;
        this.errorStatus = err.error.status;
        this.errorAlert();
        throw new Error("error");
      }))
      .subscribe(matchRequest => {
        //this.alertWithSuccess();
        // this.router.navigate(['/games']);
      });
  }




onSubmit(): void {
  this.createMatch();

}

errorAlert()  
  {  
    Swal.fire({  
      icon: 'error',  
      title: 'Matching request creation failed',  
      text: this.errorMessage,  
    })  
  }

  alertWithSuccess(){  
    Swal.fire({   
    title:'Match request created!',       
    icon: 'success',
    showConfirmButton: false,    
    timer: 1500 
  })  
  } 
}




