import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ShoppingCart } from '../model/ShoppingCart.model';
import { Item } from '../../item/modelo/item.model';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  
  constructor(
    private http : HttpClient
  ) { }

  getCartByUserId(userId: number) {
    let urlEndpoint: string = "http://localhost:8080/store/users/"+userId+"/cart";
    return this.http.get<ShoppingCart>(urlEndpoint, { observe: 'response' });
  }

  addItemToCart(item: Item, userId: number){
    let urlEndpoint: string = "http://localhost:8080/store/users/"+userId+"/cart/addItem";
    return this.http.post<ShoppingCart>(urlEndpoint, item, { observe: 'response' });
  }
  asignQuantityToItem(newQuantity: number, cartId: number, userId: number) {
    let urlEndpoint: string = "http://localhost:8080/store/users/"+userId+"/cart/"+cartId+"/"+newQuantity;
    return this.http.patch<ShoppingCart>(urlEndpoint, { observe: 'response' });
  }
}
