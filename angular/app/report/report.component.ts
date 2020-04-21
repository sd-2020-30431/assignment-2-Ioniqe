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

  constructor( private route: ActivatedRoute,
    private _router: Router) { 
    this.route.params.subscribe( params => {this.username = params['username']});
  }

  ngOnInit(): void {
  }

  weeklyReports(){

  }

  monthlyReports(){

  }

  goBackToLists(){
    this._router.navigate(['/lists', this.username]);
  }
}
