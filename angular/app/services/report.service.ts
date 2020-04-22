import { Injectable } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Report } from '../report';
import { Observable } from 'rxjs';
import { tap, map } from 'rxjs/operators';
import { Item } from '../item';

@Injectable({
  providedIn: 'root'
})
export class ReportService {

  private reportUrl = "http://localhost:8080/";

  constructor(private http: HttpClient) { 
  }

  private log(message: string) {
    console.log(message);
  }

  getEatenCalories(username:string, reportType:string): Observable<number> {
    return this.http.get<number>(this.reportUrl + "report/" + username + "/" + reportType + "/eatenCalories");
  }

  getWastedCalories(username:string, reportType:string): Observable<number> {
    return this.http.get<number>(this.reportUrl + "report/" + username + "/" + reportType + "/wastedCalories");
  }

  getEatenFood(username:string, reportType:string): Observable<Item[]> {
    return this.http.get<Item[]>(this.reportUrl + "report/" + username + "/" + reportType + "/eatenFood");
  }

  getExpiredFood(username:string, reportType:string): Observable<Item[]> {
    return this.http.get<Item[]>(this.reportUrl + "report/" + username + "/" + reportType + "/expiredFood");
  }

}
