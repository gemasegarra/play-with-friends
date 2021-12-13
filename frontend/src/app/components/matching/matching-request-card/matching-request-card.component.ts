import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { catchError } from 'rxjs/operators';
import { MatchingService } from 'src/app/services/matching.service';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';
import { MatchingOutput } from '../../model/MatchingOutput';

@Component({
  selector: 'app-matching-request-card',
  templateUrl: './matching-request-card.component.html',
  styleUrls: ['./matching-request-card.component.css']
})
export class MatchingRequestCardComponent implements OnInit {

  match!: MatchingOutput;
  matchCreator!: string;
  id!: any;
  matcher!: any;
  errorMessage!: string;
  matchers : number = 0;
  userId!: any;


  constructor(
    private matchingService: MatchingService,
    private userService: UserService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id')
    this.matcher = localStorage.getItem('user');

    this.matchingService.getMatch(this.id).subscribe(dataResult => {
      this.match = dataResult;
      this.matchers = this.match.matches.length;
      this.matchCreator = this.match.user;

  });
    this.findUserId();
}
  joinMatch(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.matchingService.joinMatch(this.id, this.matcher)
    .pipe(catchError((err: HttpErrorResponse) => {
      this.errorMessage = err.error.message;
      this.errorAlert();
      throw new Error("error");
    }))
    .subscribe(dataResult=>{
      this.alertWithSuccess();
      console.log(dataResult);
      this.reloadPage();
    })
  }

  errorAlert()  
  {  
    Swal.fire({  
      icon: 'error',  
      title: 'This match request has enough users joined',  
    })  
  }

  alertWithSuccess(){  
    Swal.fire({   
    title:'You were added to this match request, ' + this.matcher +'!',       
    icon: 'success',
    showConfirmButton: false,  
    timer: 1500 
  })  
  }
  
  findUserId(): void{
    this.userService.findUserIdByName(this.match.user).subscribe(data => {
      this.userId = data;
  });
  }

  deleteAlert(id: number): void{
    Swal.fire({
      title: 'Are you sure you want to delete this match request?',
      showDenyButton: true,
      confirmButtonText: 'Cancel',
      denyButtonText: 'Yes! Delete it!',
    }).then((result) => {
      if (result.isDenied) {
        Swal.fire('Match deleted!', '', 'success')
        this.deleteMatch(id);
        this.router.navigate(['/matchinglist']);
        this.reloadPage();

      }
    })
    }
    
    deleteMatch(id: number): void{
      this.matchingService.deleteMatch(id).subscribe(()=>{
      console.log('match deleted')});
      }

      reloadPage() {
        setTimeout(()=>{
          window.location.reload();
        }, 100);
    }
}
