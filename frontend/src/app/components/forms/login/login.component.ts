import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { LoginService } from 'src/app/services/login.service';
import { User } from '../../model/User';


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


  constructor(private loginService: LoginService) {

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
      .subscribe(data => {
        console.log('los datos *** ' + data)
      })      
  }

  onSubmit(): void {
    console.log('Creating user...');
    console.log(this.registerForm.value)
  }

}

