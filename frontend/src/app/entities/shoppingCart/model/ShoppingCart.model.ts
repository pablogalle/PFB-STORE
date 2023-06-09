import { CartItem } from "./CartItem.model";

export class ShoppingCart {
    public id: number;
    public user: number;
    public cartItems: CartItem[]

    constructor(id: number, user: number, cartItems: CartItem[]) {
        this.id = id
        this.user = user
        this.cartItems = cartItems
    }



}