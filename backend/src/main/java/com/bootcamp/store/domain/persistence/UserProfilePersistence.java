package com.bootcamp.store.domain.persistence;

import com.bootcamp.store.domain.entity.UserProfile;

import java.util.Optional;

public interface UserProfilePersistence {

    Optional<UserProfile> getUserByUsername(String username);
    UserProfile saveUserProfile(UserProfile userProfile);

}
