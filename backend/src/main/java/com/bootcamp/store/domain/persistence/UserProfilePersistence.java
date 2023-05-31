package com.bootcamp.store.domain.persistence;

import com.bootcamp.store.application.dto.UserAuthDTO;
import com.bootcamp.store.application.dto.UserProfileDTO;
import com.bootcamp.store.domain.entity.UserProfile;

import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;

public interface UserProfilePersistence {

    Optional<UserProfile> getUserByUsername(String username);
    UserProfile saveUserProfile(UserProfile userProfile);

    List<UserProfile> getAllUsers();

    Optional<UserProfile> authenticateUser(UserAuthDTO userAuthDTO);
}
