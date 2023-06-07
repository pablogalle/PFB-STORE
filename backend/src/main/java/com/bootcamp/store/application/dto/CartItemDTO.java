package com.bootcamp.store.application.dto;

import java.io.Serializable;

public class CartItemDTO implements Serializable {
    private Long id;
    private ItemDTO item;
    private int quantity;

    public CartItemDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ItemDTO getItem() {
        return item;
    }

    public void setItem(ItemDTO item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
