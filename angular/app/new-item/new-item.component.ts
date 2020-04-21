import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Item } from '../item';
import { ItemService } from '../services/item.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-new-item',
  templateUrl: './new-item.component.html',
  styleUrls: ['./new-item.component.css']
})
export class NewItemComponent implements OnInit {

  username:string;
  listId:number;
  item: Item = new Item();

  constructor( private itemService : ItemService,
    private route: ActivatedRoute,
    private _router: Router) { }

  ngOnInit(): void {
    this.route.params.subscribe( params => {this.username = params['username']; this.listId = params['listId']});
  }

  newNameForm = new FormControl('');
  newQuantityForm = new FormControl('');
  newCaloriesForm = new FormControl('');
  newPurchaseDateForm = new FormControl('');
  newExpirationDateForm = new FormControl('');
  newConsumptionDateForm = new FormControl('');
  submitNewItem(){
    this.item.name = this.newNameForm.value;
    this.item.quantity = this.newQuantityForm.value;
    this.item.calories = this.newCaloriesForm.value;
    this.item.purchaseDate = this.newPurchaseDateForm.value;
    this.item.expirationDate = this.newExpirationDateForm.value;
    this.item.consumptionDate = this.newConsumptionDateForm.value;

    this.itemService.saveItem(this.item, this.username, this.listId).subscribe();

    // this._router.navigate(['/lists', this.username]);
    this._router.navigate(['/editList', this.username, this.listId]);

  }
}
