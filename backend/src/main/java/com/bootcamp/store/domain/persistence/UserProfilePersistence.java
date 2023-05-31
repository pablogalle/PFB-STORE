package com.bootcamp.store.domain.persistence;

import com.bootcamp.store.application.dto.UserAuthDTO;
import com.bootcamp.store.domain.entity.UserProfile;

import java.util.List;
import java.util.Optional;

public interface UserProfilePersistence {

    Optional<UserProfile> getUserByUsername(String username);
    Optional<UserProfile> saveUserProfile(UserProfile userProfile);

    List<UserProfile> getAllUsers();

    Optional<UserProfile> authenticateUser(UserAuthDTO userAuthDTO);
}
