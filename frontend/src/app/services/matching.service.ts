import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Matching } from '../components/model/Matching';

@Injectable({
  providedIn: 'root'
})
export class MatchingService {
  private readonly baseUrl: string = 'http://localhost:8080/api-v1';
  constructor(private http: HttpClient) { }


  createMatch(matchRequest: Matching): Observable<Matching> {
    const body={
      game: matchRequest.game,
      user: matchRequest.user,
      numberOfPlayers: matchRequest.numberOfPlayers,
      comment: matchRequest.comment
    };
    return this.http.post<Matching>(this.baseUrl + '/matching', body);
}
  getMatches(): Observable<Matching[]>{
    return this.http.get<Matching[]>(this.baseUrl+'/matching') 
  }
}
