package com.bootcamp.store.application.mapper;

import com.bootcamp.store.application.dto.ShoppingCartDTO;
import com.bootcamp.store.domain.entity.ShoppingCart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CartItemMapper.class, UserProfileMapper.class})
public interface ShoppingCartMapper extends EntityMapper<ShoppingCartDTO, ShoppingCart> {

    @Override
    @Mapping(source = "user", target = "user")
    @Mapping(source = "cartItems", target = "cartItems")
    ShoppingCartDTO toDto(ShoppingCart entity);

    @Override
    @Mapping(source = "user", target = "user")
    @Mapping(source = "cartItems", target = "cartItems")
    ShoppingCart toEntity(ShoppingCartDTO dto);
}
