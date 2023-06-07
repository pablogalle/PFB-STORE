package com.bootcamp.store.application.mapper;

import com.bootcamp.store.application.dto.CartItemDTO;
import com.bootcamp.store.domain.entity.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ItemMapper.class)
public interface CartItemMapper extends EntityMapper<CartItemDTO, CartItem>{

    @Override
    @Mapping(source = "shoppingCart.id", target = "shoppingCartId")
    CartItemDTO toDto(CartItem cartItem);
    @Override
    @Mapping(source = "shoppingCartId", target = "shoppingCart.id")
    CartItem toEntity(CartItemDTO cartItemDTO);
}
