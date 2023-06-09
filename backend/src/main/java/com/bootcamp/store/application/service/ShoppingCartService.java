package com.bootcamp.store.application.service;

import com.bootcamp.store.application.dto.ItemDTO;
import com.bootcamp.store.application.dto.ShoppingCartDTO;

import java.util.Optional;

public interface ShoppingCartService {

    Optional<ShoppingCartDTO> getShoppingCartById(Long id);

    ShoppingCartDTO createShoppingCartByUserId(Long userId);

    Optional<ShoppingCartDTO> getShoppingCartByUserId(Long userId);

    ShoppingCartDTO addItemToCartByUserId(Long userId, ItemDTO itemDTO);

    void deleteItemFromCart(Long userId, Long cartItemId);

    void asignQuantityToCartItem(Long userId, Long cartItemId, Integer quantity);
}
