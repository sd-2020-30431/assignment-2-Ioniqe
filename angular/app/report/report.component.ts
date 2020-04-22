import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {

  username:string;
  listId:number;
  userGoal:number;

  constructor( private route: ActivatedRoute,
    private _router: Router) { 
    this.route.params.subscribe( params => {this.username = params['username']; this.userGoal = params['userGoal']});
  }

  ngOnInit(): void {
  }

  weeklyReports(){
    this._router.navigate(['/report', this.username, 'WEEKLY', this.userGoal]);
  }

  monthlyReports(){
    this._router.navigate(['/report', this.username, 'MONTHLY', this.userGoal]);
  }

  goBackToLists(){
    this._router.navigate(['/lists', this.username]);
  }

  goToGoalStats(){
    this._router.navigate(['lists/displayGoalStats', this.username, this.userGoal]);
  }
}
