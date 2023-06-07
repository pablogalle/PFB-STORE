package com.bootcamp.store.application.service.impl;

import com.bootcamp.store.application.dto.ShoppingCartDTO;
import com.bootcamp.store.application.mapper.ShoppingCartMapper;
import com.bootcamp.store.application.service.ShoppingCartService;
import com.bootcamp.store.domain.persistence.ShoppingCartPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartPersistence persistence;
    private final ShoppingCartMapper mapper;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartPersistence persistence, ShoppingCartMapper mapper){
        this.persistence = persistence;
        this.mapper = mapper;
    }

    @Override
    public ShoppingCartDTO getShoppingCartById(Long id) {
        return null;
    }
}
