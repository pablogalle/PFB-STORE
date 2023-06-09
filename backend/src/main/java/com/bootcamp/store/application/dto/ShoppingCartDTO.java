package com.bootcamp.store.application.dto;


import java.io.Serializable;
import java.util.List;

public class ShoppingCartDTO implements Serializable {
    private Long id;
    private Long user;
    private List<CartItemDTO> cartItems;

    public ShoppingCartDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public List<CartItemDTO> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemDTO> cartItems) {
        this.cartItems = cartItems;
    }
}
