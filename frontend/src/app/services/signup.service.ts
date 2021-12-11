import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserAuth } from '../components/model/UserAuth';


@Injectable({
  providedIn: 'root'
})
export class SignupService {

  private readonly baseUrl: string = 'http://localhost:8080/api-v1';
  constructor(private http: HttpClient) { }


  register(user: UserAuth): Observable<UserAuth> {
    const body={
      username: user.username,
      email: user.email,
      password: user.password,
      
    };
    return this.http.post<UserAuth>(this.baseUrl + '/register', body)
}
}
