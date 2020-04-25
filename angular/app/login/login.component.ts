import { Component, OnInit, Output } from '@angular/core';
import { FormControl } from '@angular/forms';
import { User } from '../user';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  title = 'Wasteless App';
  errorsg = "";

  constructor(private httpClient:HttpClient,
    private _router: Router){ }

  ngOnInit(): void {
  }

  usernameForm = new FormControl('');
  passwordForm = new FormControl('');
  verifyLogin ()  {
    return this.httpClient.post<User>('http://localhost:8080/login2', {username: this.usernameForm.value, password:this.passwordForm.value})
    .subscribe(response => {
      if(response.username != null && response.username != null){
        this._router.navigate(['/lists', response.username]);
      }
    });
  }

  gotoNewUserPage(pageName:string) :void {
    this._router.navigate([`${pageName}`]);
  }
}
