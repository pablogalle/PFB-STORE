package com.bootcamp.store.application.service.impl;

import com.bootcamp.store.application.dto.CartItemDTO;
import com.bootcamp.store.application.dto.ItemDTO;
import com.bootcamp.store.application.dto.ShoppingCartDTO;
import com.bootcamp.store.application.mapper.CartItemMapper;
import com.bootcamp.store.application.mapper.ShoppingCartMapper;
import com.bootcamp.store.application.service.ShoppingCartService;
import com.bootcamp.store.domain.persistence.ShoppingCartPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartPersistence persistence;
    private final ShoppingCartMapper mapper;
    private final CartItemMapper cartItemMapper;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartPersistence persistence, ShoppingCartMapper mapper, CartItemMapper cartItemMapper){
        this.persistence = persistence;
        this.mapper = mapper;
        this.cartItemMapper = cartItemMapper;
    }

    @Override
    public Optional<ShoppingCartDTO> getShoppingCartById(Long id) {
        return this.persistence.getShoppingCartById(id).map(mapper::toDto);
    }

    @Override
    public Optional<ShoppingCartDTO> getShoppingCartByUserId(Long userId) {
        return this.persistence.getShoppingCartByUserId(userId).map(mapper::toDto);
    }

    @Override
    public ShoppingCartDTO createShoppingCartByUserId(Long userId) {
        return mapper.toDto(persistence.createShoppingCartByUserId(userId));
    }

    @Override
    public ShoppingCartDTO addItemToCartByUserId(Long userId, ItemDTO itemDTO) {
        CartItemDTO cartItemDTO = new CartItemDTO();
        cartItemDTO.setItemId(itemDTO.getId());
        cartItemDTO.setItemName(itemDTO.getName());
        cartItemDTO.setItemPrice(itemDTO.getPrice());
        cartItemDTO.setItemImage(itemDTO.getImage());
        cartItemDTO.setItemCategoryName(itemDTO.getCategoryName());
        cartItemDTO.setQuantity(1);
        return mapper.toDto(persistence.addItemToCartByUserId(userId, cartItemMapper.toEntity(cartItemDTO)));
    }
}
