import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Item } from '../item';
import { ActivatedRoute, Router } from '@angular/router';
import { ItemService } from '../services/item.service';

@Component({
  selector: 'app-edit-list',
  templateUrl: './edit-list.component.html',
  styleUrls: ['./edit-list.component.css']
})
export class EditListComponent implements OnInit {

  items : Observable<Item[]>;
  username:string;
  listId:number;

  constructor( private route: ActivatedRoute,
    private itemService:ItemService,
    private _router: Router) {
    this.route.params.subscribe( params => {this.username = params['username']; this.listId = params['id']});
   }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData(){
    this.items = this.itemService.getItems(this.listId, this.username);
  }

  editItem(id:number){
    this._router.navigate(['/editList/editItem', this.username, this.listId, id]);
  }

  donateItem(id:number){
    //TODO show charity list, then delete
  }

  newItem(){
    this._router.navigate(['/newItem', this.username, this.listId]);
  }

  goBackToLists(){
    this._router.navigate(['/lists', this.username]);
  }

}
