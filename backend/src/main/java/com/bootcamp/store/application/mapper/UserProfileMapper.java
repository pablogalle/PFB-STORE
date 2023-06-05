package com.bootcamp.store.application.mapper;

import com.bootcamp.store.application.dto.UserProfileDTO;
import com.bootcamp.store.domain.entity.UserProfile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserProfileMapper extends EntityMapper<UserProfileDTO, UserProfile> {
}
