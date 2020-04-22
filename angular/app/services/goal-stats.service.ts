import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Lists } from '../lists';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class GoalStatsService {

  private goalUrl = "http://localhost:8080/";

  constructor(private http: HttpClient,
    private _router: Router) { }

  getGoalStats(username:string): Observable<Lists>{
    return this.http.get<Lists>(this.goalUrl + "lists/displayGoalStats/" + username);
  }

}
