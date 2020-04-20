import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ListsComponent } from './lists/lists.component';
import { NewUserComponent } from './new-user/new-user.component';

const routes: Routes = [
  {path:'login', component: LoginComponent},
  {path:'lists/:username', component: ListsComponent},
  {path:'newUser', component: NewUserComponent},
  {path:'', component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
