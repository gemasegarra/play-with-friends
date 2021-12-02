import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Game } from '../components/model/Game';

@Injectable({
  providedIn: 'root'
})
export class GamesService {

  private readonly baseUrl: string = 'http://localhost:8080/api-v1';
  constructor(private http: HttpClient){}

  getGames(): Observable<Game[]> {
    return this.http.get<Game[]>(this.baseUrl+'/games');
  }

}
