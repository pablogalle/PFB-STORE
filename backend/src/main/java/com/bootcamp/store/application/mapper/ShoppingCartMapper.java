package com.bootcamp.store.application.mapper;

import com.bootcamp.store.application.dto.ShoppingCartDTO;
import com.bootcamp.store.domain.entity.ShoppingCart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CartItemMapper.class, UserProfileMapper.class})
public interface ShoppingCartMapper extends EntityMapper<ShoppingCartDTO, ShoppingCart> {

    @Override
    @Mapping(source = "user.id", target = "user")
    @Mapping(source = "cartItems", target = "cartItems")
    ShoppingCartDTO toDto(ShoppingCart entity);

    @Override
    @Mapping(source = "user", target = "user.id")
    @Mapping(source = "cartItems", target = "cartItems")
    ShoppingCart toEntity(ShoppingCartDTO dto);

    default ShoppingCart fromId(Long id){
        var cart = new ShoppingCart();

        if (id == null) return null;
        cart.setId(id);
        return cart;
    }

    default Long toId ( ShoppingCart cart){
        if (cart == null) return null;

        return cart.getId();
    }
}
