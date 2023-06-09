package com.bootcamp.store.infrastructure.persistence;

import com.bootcamp.store.domain.entity.ShoppingCart;
import com.bootcamp.store.domain.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    Optional<ShoppingCart> findByUser(UserProfile userId);
}
