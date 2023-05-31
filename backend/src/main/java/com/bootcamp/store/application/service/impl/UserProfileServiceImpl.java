package com.bootcamp.store.application.service.impl;

import com.bootcamp.store.application.dto.UserProfileDTO;
import com.bootcamp.store.application.mapper.UserProfileMapper;
import com.bootcamp.store.application.service.UserProfileService;
import com.bootcamp.store.domain.entity.UserProfile;
import com.bootcamp.store.domain.persistence.UserProfilePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProfileServiceImpl implements UserProfileService {
    private final UserProfilePersistence persistence;
    private final UserProfileMapper mapper;

    @Autowired
    public UserProfileServiceImpl(UserProfilePersistence persistence, UserProfileMapper mapper) {
        this.persistence = persistence;
        this.mapper = mapper;
    }

    @Override
    public Optional<UserProfileDTO> getUserByUsername(String username) {
        return this.persistence.getUserByUsername(username).map(mapper :: toDto );
    }

    @Override
    public UserProfileDTO saveUserProfile(UserProfileDTO userProfileDTO) {
        UserProfile userSaved = this.persistence.saveUserProfile(this.mapper.toEntity(userProfileDTO));
        return this.mapper.toDto(userSaved);
    }
}
