import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { User } from '../user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl = "http://localhost:8080";

  constructor(private http: HttpClient) { }

  updateGoalForUser(user:User): Observable<Object> {
    return this.http.put(this.baseUrl + "/lists/updateUserGoal", user);
  }

  saveNewUser(user : User): Observable<Object>{
    return this.http.post(this.baseUrl + "/newUser", user);
  }
}
