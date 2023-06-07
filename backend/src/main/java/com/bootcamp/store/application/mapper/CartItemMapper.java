package com.bootcamp.store.application.mapper;

import com.bootcamp.store.application.dto.CartItemDTO;
import com.bootcamp.store.domain.entity.CartItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ItemMapper.class)
public interface CartItemMapper extends EntityMapper<CartItemDTO, CartItem>{

    @Override
    CartItemDTO toDto(CartItem cartItem);
    @Override
    CartItem toEntity(CartItemDTO cartItemDTO);
}
