package com.bootcamp.store.infrastructure.persistence;

import com.bootcamp.store.domain.persistence.ShoppingCartPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShoppingCartPersistenceImpl implements ShoppingCartPersistence {

    private final ShoppingCartRepository cartRepository;

    @Autowired
    public ShoppingCartPersistenceImpl(ShoppingCartRepository cartRepository){
        this.cartRepository = cartRepository;
    }
}
