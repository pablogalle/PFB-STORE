package com.bootcamp.store.application.mapper;

import com.bootcamp.store.application.dto.CartItemDTO;
import com.bootcamp.store.domain.entity.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ItemMapper.class)
public interface CartItemMapper extends EntityMapper<CartItemDTO, CartItem>{

    @Override
    @Mapping(source = "shoppingCart.id", target = "shoppingCartId")
    @Mapping(source = "item.id", target = "itemId")
    @Mapping(source = "item.name", target = "itemName")
    @Mapping(source = "item.price", target = "itemPrice")
    @Mapping(source = "item.image", target = "itemImage")
    @Mapping(source = "item.category.name", target = "itemCategoryName")
    CartItemDTO toDto(CartItem cartItem);
    @Override
    @Mapping(source = "shoppingCartId", target = "shoppingCart.id")
    @Mapping(source = "itemId", target = "item.id")
    @Mapping(source = "itemName", target = "item.name")
    @Mapping(source = "itemPrice", target = "item.price" )
    @Mapping(source = "itemImage", target = "item.image" )
    @Mapping(source = "itemCategoryName", target = "item.category.name")
    CartItem toEntity(CartItemDTO cartItemDTO);
}
