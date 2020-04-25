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

  saveItem(item : Item, username:string, listId:number): Observable<Object>{
    return this.http.post(this.listUrl + "/newItem/" + username + "/" + listId, item);
  }

  editItem(item : Item, username:string, listId:number, itemId:number): Observable<Object>{
    return this.http.post(this.listUrl + "editList/editItem/" + username + "/" + listId + "/" + itemId, item);
  }

  getItemById(itemId:number): Observable<any>{
    return this.http.get(this.listUrl + "getItem/" + itemId);
  }

  deleteItem(id:number): Observable<any> {
    return this.http.delete(this.listUrl + "donate_item/" + id);
  }

  getExpiredItems(username:string): Observable<Item[]>{
    return this.http.get<Item[]>(this.listUrl + "notification/" + username);
  }
  
}
