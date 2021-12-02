import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../components/model/User';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  
  private readonly baseUrl: string = 'http://localhost:8080/api-v1';
  constructor(private http: HttpClient) { }


  login(user: User): Observable<User> {
    const body={
      name: user.name,
      password: user.password,
      
    };
    return this.http.post<User>(this.baseUrl + '/login', body)
}
}
