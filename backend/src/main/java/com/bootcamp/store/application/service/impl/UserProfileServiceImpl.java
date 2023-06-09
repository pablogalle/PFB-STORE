package com.bootcamp.store.application.service.impl;

import com.bootcamp.store.application.dto.UserAuthDTO;
import com.bootcamp.store.application.dto.UserProfileDTO;
import com.bootcamp.store.application.mapper.UserProfileMapper;
import com.bootcamp.store.application.service.UserProfileService;
import com.bootcamp.store.domain.entity.UserProfile;
import com.bootcamp.store.domain.persistence.UserProfilePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserProfileServiceImpl implements UserProfileService {
    private final UserProfilePersistence persistence;
    private final UserProfileMapper mapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    public UserProfileServiceImpl(UserProfilePersistence persistence, UserProfileMapper mapper) {
        this.persistence = persistence;
        this.mapper = mapper;
    }

    @Override
    public Optional<UserProfileDTO> getUserByUsername(String username) {
        return this.persistence.getUserByUsername(username).map(mapper::toDto);
    }

    @Override
    public Optional<UserProfileDTO> saveUserProfile(UserProfileDTO userProfileDTO) {
        //encode pass
        return this.persistence.saveUserProfile(this.mapper.toEntity(userProfileDTO)).map(mapper::toDto);

    }

    @Override
    public List<UserProfileDTO> getAllUsers() {
        List<UserProfile> users = this.persistence.getAllUsers();
        return this.mapper.toDto(users);
    }

    @Override
    public Optional<UserProfileDTO> authenticateUser(UserAuthDTO userAuthDTO) {
        return this.persistence.authenticateUser(userAuthDTO).map(mapper::toDto);
    }

    @Override
    public UserProfileDTO addFavouriteItem(Long userId, Long itemId) {
        Optional<UserProfileDTO> userProfileDTOOpt = this.persistence.getUserById(userId).map(mapper::toDto);
        if (userProfileDTOOpt.isPresent()) {
            UserProfileDTO userProfileDTO = userProfileDTOOpt.get();
            if (!userProfileDTO.getFavouriteItemsIds().contains(itemId)) userProfileDTO.getFavouriteItemsIds().add(itemId);
            else userProfileDTO.getFavouriteItemsIds().remove(itemId);
            return mapper.toDto(this.persistence.updateUserProfile(this.mapper.toEntity(userProfileDTO)));
        }
        return null;
    }
}
