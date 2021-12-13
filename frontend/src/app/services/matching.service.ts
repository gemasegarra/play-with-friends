import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MatchingOutput } from '../components/model/MatchingOutput';
import { MatchingRequest } from '../components/model/MatchingRequest';

@Injectable({
  providedIn: 'root'
})
export class MatchingService {
  private readonly baseUrl: string = 'http://localhost:8080/api-v1';
  constructor(private http: HttpClient) {}

  createMatch(matchRequest: MatchingRequest): Observable<MatchingRequest> {
    const body = {
      gameId: matchRequest.game,
      user: matchRequest.user,
      numberOfPlayers: matchRequest.numberOfPlayers,
      comment: matchRequest.comment
    };
    return this.http.post<MatchingRequest>(this.baseUrl + '/matching', body);
  }
  getMatches(): Observable<MatchingOutput[]> {
    return this.http.get<MatchingOutput[]>(this.baseUrl + '/matching');
  }

  getMatch(id: number): Observable<MatchingOutput> {
    return this.http.get<MatchingOutput>(`${this.baseUrl}/matching/${id}`);
  }

  getMatchByMatcher(matcher: string): Observable<MatchingOutput[]> {
    return this.http.get<MatchingOutput[]>(
      `${this.baseUrl}/matching?matcher=${matcher}`
    );
  }
  getMatchByUser(user: string): Observable<MatchingOutput[]> {
    return this.http.get<MatchingOutput[]>(
      `${this.baseUrl}/matching?user=${user}`
    );
  }

  joinMatch(id: number, matcher: string): Observable<any> {
    const body = {
      matcher: matcher
    };
    return this.http.post(`${this.baseUrl}/matching/${id}`, body);
  }

  deleteMatch(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/matching/${id}`);
  }
}
