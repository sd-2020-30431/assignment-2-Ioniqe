import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Report } from '../report';
import { ReportService } from '../services/report.service';
import { Observable, AsyncSubject } from 'rxjs';
import { map } from 'rxjs/operators';
import { Item } from '../item';

@Component({
  selector: 'app-report-details',
  templateUrl: './report-details.component.html',
  styleUrls: ['./report-details.component.css']
})
export class ReportDetailsComponent implements OnInit {

  username:string;
  reportType:string;
  userGoal:number;

  eatenFood:Observable<Item[]>;
  expiredFood:Observable<Item[]>;
  eatenCalories:Observable<number>;
  wastedCalories:Observable<number>;

  constructor(private route: ActivatedRoute,
    private _router: Router,
    private reportService:ReportService) { 
    this.route.params.subscribe( params => {this.username = params['username']; this.reportType = params['reportType']; this.userGoal = params['userGoal']});
  }

  ngOnInit(): void {
    this.eatenCalories = this.reportService.getEatenCalories(this.username, this.reportType);
    this.wastedCalories = this.reportService.getWastedCalories(this.username, this.reportType);

    this.eatenFood = this.reportService.getEatenFood(this.username, this.reportType);
    this.expiredFood = this.reportService.getExpiredFood(this.username, this.reportType);
  }

  backToLists(){
    this._router.navigate(['/lists', this.username]);
  }

}
