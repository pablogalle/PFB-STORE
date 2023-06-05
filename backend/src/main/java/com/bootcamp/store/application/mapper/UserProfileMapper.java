package com.bootcamp.store.application.mapper;

import com.bootcamp.store.application.dto.UserProfileDTO;
import com.bootcamp.store.domain.entity.UserProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ItemMapper.class)
public interface UserProfileMapper extends EntityMapper<UserProfileDTO, UserProfile> {
    @Override
    @Mapping(source = "favourites", target = "favouriteItemsIds")
    UserProfileDTO toDto(UserProfile entity);

    @Override
    @Mapping(source = "favouriteItemsIds", target = "favourites")
    UserProfile toEntity(UserProfileDTO dto);
}
