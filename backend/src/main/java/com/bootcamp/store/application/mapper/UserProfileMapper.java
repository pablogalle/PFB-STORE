package com.bootcamp.store.application.mapper;

import com.bootcamp.store.application.dto.UserProfileDTO;
import com.bootcamp.store.domain.entity.UserProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ItemMapper.class, ShoppingCartMapper.class})
public interface UserProfileMapper extends EntityMapper<UserProfileDTO, UserProfile> {
    @Override
    @Mapping(source = "favouriteItems", target = "favouriteItemsIds")
    @Mapping(source = "shoppingCart", target = "shoppingCartId")
    UserProfileDTO toDto(UserProfile entity);

    @Override
    @Mapping(source = "favouriteItemsIds", target = "favouriteItems")
    @Mapping(source = "shoppingCartId", target = "shoppingCart")
    UserProfile toEntity(UserProfileDTO dto);
}
