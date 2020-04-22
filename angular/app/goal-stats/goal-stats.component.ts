import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { GoalStatsService } from '../services/goal-stats.service';
import { Observable, of } from 'rxjs';
import { Lists } from '../lists';

@Component({
  selector: 'app-goal-stats',
  templateUrl: './goal-stats.component.html',
  styleUrls: ['./goal-stats.component.css']
})
export class GoalStatsComponent implements OnInit {

  username:string;
  userGoal:number;

  waste: Observable<Lists>; //unconventional way; I used the name from list because I got errors if I used string simply

  constructor(private route: ActivatedRoute,
    private _router: Router,
    private goalService: GoalStatsService) {
      this.route.params.subscribe( params => {this.username = params['username']; this.userGoal = params['userGoal']});
     }

  ngOnInit(): void {
    this.waste = this.goalService.getGoalStats(this.username);
    // this.waste = of("EEEEEEE");
  }

  goBackToLists(){
    this._router.navigate(['/lists', this.username]);
  }

}
