import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { catchError } from 'rxjs/operators';
import { SignupService } from 'src/app/services/signup.service';
import { CustomValidators } from 'src/app/utils/customValidators';
import Swal from 'sweetalert2';
import { UserAuth } from '../../model/UserAuth';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css', '../forms.css']
})
export class SignupComponent implements OnInit {

    registerForm: FormGroup;
    nameInput: FormControl;
    emailInput: FormControl;
    passwordInput: FormControl;
    passwordConfirmInput: FormControl;
    user!: UserAuth;
    errorMessage!: string;
    errorStatus!: number;

  constructor(private signupService: SignupService, private router: Router) { 
    this.nameInput = new FormControl('', [ Validators.required]);
    this.passwordInput = new FormControl('', [Validators.required]);
    this.emailInput = new FormControl('', [Validators.required, Validators.email]);
    this.passwordInput = new FormControl('', [Validators.required]);
    this.passwordConfirmInput = new FormControl('', [Validators.required]);


    this.registerForm = new FormGroup({
      name: this.nameInput,
      email: this.emailInput,
      password: this.passwordInput
    }, [CustomValidators.samePassword]);
  }

  ngOnInit(): void {
  }

  signup() {
  
  
    this.user = new UserAuth(this.nameInput.value, this.emailInput.value, this.passwordInput.value)
    this.signupService.register(this.user)
    .pipe(catchError((err: HttpErrorResponse) => {
      this.errorMessage = err.error.message;
      this.errorStatus = err.error.status;
      this.errorAlert();
      throw new Error("error");
    }))
    .subscribe(user => {
      this.alertWithSuccess();
      this.router.navigate(['/games']);

    });    
  }

  onSubmit(): void {

    this.signup();

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
    title:'Welcome, ' + this.user.username,       
    icon: 'success',
    showConfirmButton: false,  
    timer: 1500 
  })  
  } 
}

