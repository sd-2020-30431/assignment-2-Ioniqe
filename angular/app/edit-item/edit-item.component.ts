import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Item } from '../item';
import { ItemService } from '../services/item.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-edit-item',
  templateUrl: './edit-item.component.html',
  styleUrls: ['./edit-item.component.css']
})
export class EditItemComponent implements OnInit {

  oldItem:Item = new Item();
  itemList:Observable<Item[]>;

  item:Item = new Item();
  username:string;
  listId:number;
  itemId:number;

  constructor(private itemService : ItemService,
    private route: ActivatedRoute,
    private _router: Router) { 
    this.route.params.subscribe( params => {this.username = params['username']; this.listId = params['listId']; this.itemId = params['itemId']});
  }

  ngOnInit(): void {
    this.item.id = this.itemId;

    this.itemService.getItemById(this.itemId).subscribe((data:Item) => {
      this.editNameForm = new FormControl(data.name);
      this.editQuantityForm = new FormControl(data.quantity);
      this.editCaloriesForm = new FormControl(data.calories);
      this.editPurchaseDateForm = new FormControl(data.purchaseDate);
      this.editExpirationDateForm = new FormControl(data.expirationDate);
      this.editConsumptionDateForm = new FormControl(data.consumptionDate);
    });

  }

  editNameForm = new FormControl('');
  editQuantityForm = new FormControl('');
  editCaloriesForm = new FormControl('');
  editPurchaseDateForm = new FormControl('');
  editExpirationDateForm = new FormControl('');
  editConsumptionDateForm = new FormControl('');
  editItem(){
    this.item.name = this.editNameForm.value;
    this.item.quantity = this.editQuantityForm.value;
    this.item.calories = this.editCaloriesForm.value;
    this.item.purchaseDate = this.editPurchaseDateForm.value;
    this.item.expirationDate = this.editExpirationDateForm.value;
    this.item.consumptionDate = this.editConsumptionDateForm.value;

    this.itemService.editItem(this.item, this.username, this.listId, this.itemId).subscribe();

    this._router.navigate(['/editList', this.username, this.listId]);

  }
}
