import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DonateService } from '../services/donate.service';
import { Charity } from '../charity';
import { Observable } from 'rxjs';
import { ItemService } from '../services/item.service';

@Component({
  selector: 'app-donate',
  templateUrl: './donate.component.html',
  styleUrls: ['./donate.component.css']
})
export class DonateComponent implements OnInit {

  itemId:number;
  charities : Observable<Charity[]>;
  username:string;
  listId:number;


  constructor(private route: ActivatedRoute,
    private donateService:DonateService,
    private itemService:ItemService,
    private _router: Router) {
    this.route.params.subscribe( params => {this.itemId = params['itemId']; this.listId = params['listId']; this.username = params['username'];});
   }

  ngOnInit(): void {
    this.charities = this.donateService.getCharities(this.itemId);
  }

  donateToThisCharity(){
    this.itemService.deleteItem(this.itemId).subscribe();

    this._router.navigate(['/editList', this.username, this.listId]);
  }

}
