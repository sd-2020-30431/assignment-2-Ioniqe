import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  title = 'Wasteless App';

  constructor(private _router: Router) {
  }
  
  ngOnInit(): void {

  }

  gotoLoginPage(pageName:string) :void {
    this._router.navigate([`${pageName}`]);
  }
}
