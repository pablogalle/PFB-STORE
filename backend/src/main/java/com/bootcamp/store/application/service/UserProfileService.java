package com.bootcamp.store.application.service;

import com.bootcamp.store.application.dto.UserAuthDTO;
import com.bootcamp.store.application.dto.UserProfileDTO;

import java.util.List;
import java.util.Optional;

public interface UserProfileService {
    Optional<UserProfileDTO> getUserByUsername(String username);
    Optional<UserProfileDTO> saveUserProfile(UserProfileDTO userProfile);
    List<UserProfileDTO> getAllUsers();

    Optional<UserProfileDTO> authenticateUser(UserAuthDTO userAuthDTO);

    UserProfileDTO addFavouriteItem(Long userId, Long itemId);
}
