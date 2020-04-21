import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Item } from '../item';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  private listUrl = "http://localhost:8080/";

  constructor(private http: HttpClient) { }

  private log(message: string) {
    console.log(message);
  }

  getItems(id:number, username:string): Observable<Item[]> {
    return this.http.get<Item[]>(this.listUrl + "editList/" + username + "/"+ id)
      .pipe(
        tap(_ => this.log('fetched items')));
  }

  // /newItem/{username}/{listId}
  saveItem(item : Item, username:string, listId:number): Observable<Object>{
    return this.http.post(this.listUrl + "/newItem/" + username + "/" + listId, item);
  }
}
