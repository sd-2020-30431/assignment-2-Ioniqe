import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ListsComponent } from './lists/lists.component';
import { NewUserComponent } from './new-user/new-user.component';
import { ReportComponent } from './report/report.component';
import { EditListComponent } from './edit-list/edit-list.component';
import { NewItemComponent } from './new-item/new-item.component';
import { EditItemComponent } from './edit-item/edit-item.component';

const routes: Routes = [
  {path:'login', component: LoginComponent},
  {path:'lists/:username', component: ListsComponent},
  {path:'newUser', component: NewUserComponent},
  {path:'reports/:username', component: ReportComponent},
  {path:'editList/:username/:id', component: EditListComponent},
  {path:'newItem/:username/:listId', component: NewItemComponent},
  {path:'editList/editItem/:username/:listId/:itemId', component: EditItemComponent},
  {path:'', component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
