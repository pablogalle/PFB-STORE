import { Component, OnInit } from '@angular/core';
import { CartService } from '../service/cart.service';
import { AuthenticationService } from 'src/app/authentication/services/authentication.service';
import { CartItem } from '../model/CartItem.model';
import { MessageService } from 'primeng/api';

@Component({
  selector: 'app-shopping-cart-list',
  templateUrl: './shopping-cart-list.component.html',
  styleUrls: ['./shopping-cart-list.component.scss']
})
export class ShoppingCartListComponent implements OnInit {

  cartItems: CartItem[] = []


  constructor(
    private cartService: CartService,
    private authService: AuthenticationService
  ) { }

  ngOnInit(): void {
    this.getCartItems();
  }

  getCartItems() {
    if (this.authService.userProfile) {
      this.cartService.getCartByUserId(this.authService.userProfile.id!).subscribe(
        data => {
          this.cartItems = data.body!.cartItems
          console.log(this.cartItems)
        }
      );
    }
  }

  asignQuantity(cartItem : CartItem, newQuantity: number){
    let userId = this.authService.userProfile!.id!
    let cartId = cartItem.id
    if(newQuantity<=0){
      this.cartItems.splice(this.cartItems.indexOf(cartItem), 1)
    }else cartItem.quantity = newQuantity
    this.cartService.asignQuantityToItem(newQuantity, cartId, userId).subscribe()
    
  }

}

