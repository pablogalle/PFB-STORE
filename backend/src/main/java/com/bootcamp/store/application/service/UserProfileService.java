package com.bootcamp.store.application.service;

import com.bootcamp.store.application.dto.UserProfileDTO;

import java.util.Optional;

public interface UserProfileService {
    Optional<UserProfileDTO> getUserByUsername(String username);
    UserProfileDTO saveUserProfile(UserProfileDTO userProfile);
}
