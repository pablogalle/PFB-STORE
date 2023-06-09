package com.bootcamp.store.infrastructure.persistence;

import com.bootcamp.store.application.dto.UserAuthDTO;
import com.bootcamp.store.application.dto.UserProfileDTO;
import com.bootcamp.store.domain.entity.UserProfile;
import com.bootcamp.store.domain.persistence.ShoppingCartPersistence;
import com.bootcamp.store.domain.persistence.UserProfilePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class UserProfilePersistenceImpl implements UserProfilePersistence {
    private final UserProfileRepository userRepository;
    private final ShoppingCartPersistence cartPersistence;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    public UserProfilePersistenceImpl(UserProfileRepository userRepository, ShoppingCartPersistence cartPersistence) {
        this.userRepository = userRepository;
        this.cartPersistence = cartPersistence;
    }

    @Override
    public Optional<UserProfile> getUserByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public Optional<UserProfile> saveUserProfile(UserProfile userProfile) {
        if (getUserByUsername(userProfile.getUsername()).isPresent()) return Optional.empty();
        userProfile.setPassword(passwordEncoder.encode(userProfile.getPassword()));
        UserProfile profile = this.userRepository.save(userProfile);
        profile.setShoppingCart(cartPersistence.createShoppingCartByUserId(profile.getId()));
        return Optional.of(this.userRepository.save(profile));
    }

    @Override
    public List<UserProfile> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public Optional<UserProfile> authenticateUser(UserAuthDTO userAuthDTO) {
        Optional<UserProfile> userProfile = getUserByUsername(userAuthDTO.getUsername());
        if (userProfile.isPresent()) {
            boolean passwordMatch = passwordEncoder.matches(userAuthDTO.getPassword(), userProfile.get().getPassword());
            if (passwordMatch) {
                return userProfile;
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<UserProfile> getUserById(Long userId) {
        return this.userRepository.findById(userId);
    }

    @Override
    public UserProfile updateUserProfile(UserProfile userProfile) {
        return userRepository.save(userProfile);
    }
}
