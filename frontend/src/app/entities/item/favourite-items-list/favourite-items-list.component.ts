import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MessageService } from 'primeng/api';
import { AuthenticationService } from 'src/app/authentication/services/authentication.service';
import { ItemService } from '../service/item.service';
import { Item } from '../modelo/item.model';

@Component({
  selector: 'app-favourite-items-list',
  templateUrl: './favourite-items-list.component.html',
  styleUrls: ['./favourite-items-list.component.scss']
})
export class FavouriteItemsListComponent implements OnInit {


  items : Item[] = []

  constructor(
    private itemService: ItemService,
    private messageService: MessageService,
    private authenticationService: AuthenticationService) { }

  ngOnInit(): void {
    this.GetFavouriteItems()
  }

  GetFavouriteItems() {
    const favItemsIds = this.authenticationService.userProfile!.favouriteItemsIds!
    console.log(favItemsIds)
    favItemsIds.forEach(itemId => {
      this.itemService.getItemById(itemId).subscribe(
        data => {
          this.items.push(data)
          console.log(this.items)
        }
      )
    });
  }

  toggleFavourite(id: number) {
    this.authenticationService.addFavouriteItem(id).subscribe(
      next => {
        this.authenticationService.userProfile!.favouriteItemsIds = next.favouriteItemsIds
      },
      error => {
        console.log(error)
      }
    )
  }

  isItemFav(itemId: number) {
    if (this.authenticationService.userProfile!.favouriteItemsIds!.indexOf(itemId) > -1) return true
    return false
  }
}
