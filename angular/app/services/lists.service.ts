import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { Lists } from '../lists';
import { catchError, map, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ListsService {

  private listUrl = "http://localhost:8080/";

  constructor(private http: HttpClient) { }

  private log(message: string) {
    console.log(message);
  }

  getLists(username:string): Observable<Lists[]> {
    return this.http.get<Lists[]>(this.listUrl + "lists/" + username)
      .pipe(
        tap(_ => this.log('fetched lists')));
  }

  saveList(list:Lists, username:string): Observable<Object> {
    return this.http.post(this.listUrl + "lists/" + username, list);
  }

  deleteList(id:number, username:string): Observable<any> {
    return this.http.delete(this.listUrl + "/delete/" + username + "/" + id);
  }
}
