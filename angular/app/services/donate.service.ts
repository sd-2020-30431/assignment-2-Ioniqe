import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Charity } from '../charity';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class DonateService {

  private charityUrl = "http://localhost:8080/";

  constructor(private http: HttpClient) { }

  private log(message: string) {
    console.log(message);
  }

  getCharities(itemId:number): Observable<Charity[]> {
    return this.http.get<Charity[]>(this.charityUrl + "donateToCharity/" + itemId)
      .pipe(
        tap(_ => this.log('fetched charities')));
  }
}
