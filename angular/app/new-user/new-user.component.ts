import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { User } from '../user';
import { UserService } from '../services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-user',
  templateUrl: './new-user.component.html',
  styleUrls: ['./new-user.component.css']
})
export class NewUserComponent implements OnInit {

  user:User = new User();

  constructor( private userService : UserService,
    private _router: Router ) { }

  ngOnInit(): void {
  }

  newUsernameForm = new FormControl('');
  newPasswordForm = new FormControl('');
  submitNewUser(){
    this.user.username = this.newUsernameForm.value;
    this.user.password = this.newPasswordForm.value;

    this.userService.saveNewUser(this.user).subscribe();

    this._router.navigate(["login"]);
  }

}
