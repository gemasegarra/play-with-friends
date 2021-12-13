import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Game } from '../components/model/Game';
import { UserProfile } from '../components/model/UserProfile';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private readonly baseUrl: string = 'http://localhost:8080/api-v1';
  constructor(private http: HttpClient) {}

  getUser(id: number): Observable<UserProfile> {
    return this.http.get<UserProfile>(`${this.baseUrl}/users/${id}`);
  }

  findUserIdByName(name: string): Observable<number> {
    return this.http.get<number>(`${this.baseUrl}/users/id/?username=${name}`);
  }
}
