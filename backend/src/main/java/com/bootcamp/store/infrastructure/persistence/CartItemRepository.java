package com.bootcamp.store.infrastructure.persistence;

import com.bootcamp.store.domain.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
