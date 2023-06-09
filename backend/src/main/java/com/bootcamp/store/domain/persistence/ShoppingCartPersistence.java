package com.bootcamp.store.domain.persistence;

import com.bootcamp.store.application.dto.ItemDTO;
import com.bootcamp.store.application.dto.ShoppingCartDTO;
import com.bootcamp.store.domain.entity.CartItem;
import com.bootcamp.store.domain.entity.ShoppingCart;

import java.util.Optional;

public interface ShoppingCartPersistence {
    Optional<ShoppingCart> getShoppingCartById(Long id);

    ShoppingCart createShoppingCartByUserId(Long userId);

    Optional<ShoppingCart> getShoppingCartByUserId(Long userId);

    ShoppingCart addItemToCartByUserId(Long userId, CartItem itemDTO);
}
