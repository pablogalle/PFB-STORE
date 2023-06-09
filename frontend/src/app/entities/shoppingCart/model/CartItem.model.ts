export class CartItem {
    public id: number;
    public shoppingCartId: number;
    public quantity: number;
    public itemId: number;
    public itemName: string;
    public itemPrice: number;
    public itemImage?: string;
    public itemCategoryName: string;

    constructor(
        id: number,
        shoppingCartId: number,
        quantity: number,
        itemId: number,
        itemName: string,
        itemPrice: number,
        itemCategoryName: string,
        itemImage?: string
    ) {
        this.id = id
        this.shoppingCartId = shoppingCartId
        this.quantity = quantity
        this.itemId = itemId
        this.itemName = itemName
        this.itemPrice = itemPrice
        this.itemImage = itemImage
        this.itemCategoryName = itemCategoryName
    }
}