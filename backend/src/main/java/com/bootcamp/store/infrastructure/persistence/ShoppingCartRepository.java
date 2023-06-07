package com.bootcamp.store.infrastructure.persistence;

import com.bootcamp.store.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<Category, Long> {
}
