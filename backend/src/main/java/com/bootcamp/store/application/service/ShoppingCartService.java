package com.bootcamp.store.application.service;

import com.bootcamp.store.application.dto.ShoppingCartDTO;

public interface ShoppingCartService {

    ShoppingCartDTO getShoppingCartById(Long id);
}
