import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { LoginService } from 'src/app/services/login.service';
import { User } from '../../model/User';
import { catchError } from 'rxjs/operators';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css', '../forms.css']
})
export class LoginComponent implements OnInit {

  registerForm: FormGroup;
  nameInput: FormControl;
  passwordInput: FormControl;
  user!: User;    
  errorMessage!: string;
  errorStatus!: number;



  constructor(private loginService: LoginService, private router: Router) {

    this.nameInput = new FormControl('', [ Validators.required]);
    this.passwordInput = new FormControl('', [Validators.required]);


    this.registerForm = new FormGroup({
      name: this.nameInput,
      password: this.passwordInput
  
    });
  }

  ngOnInit(): void {
  }

  login() {
  
  
    this.user = new User(this.nameInput.value, this.passwordInput.value)
    this.loginService.login(this.user)
      .pipe(catchError((err: HttpErrorResponse) => {
        this.errorMessage = err.error.message;
        this.errorStatus = err.error.status;
        this.errorAlert();
        throw new Error("error");
      }))
      .subscribe((user) => {
        this.alertWithSuccess();
        localStorage.setItem('user', this.user.name);
        this.router.navigate(['/games']);
      });
  }

  onSubmit(): void {
    this.login();
  
  }


  errorAlert()  
  {  
    Swal.fire({  
      icon: 'error',  
      title: 'Login failed',  
      text: this.errorMessage,  
    })  
  }

  alertWithSuccess(){  
    Swal.fire({   
    title:'Welcome, ' + this.user.name,       
    icon: 'success',
    showConfirmButton: false,    
    timer: 1500 
  })  
  } 
}



