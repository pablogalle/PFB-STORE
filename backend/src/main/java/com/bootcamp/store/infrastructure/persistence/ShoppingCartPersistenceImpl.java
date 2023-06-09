package com.bootcamp.store.infrastructure.persistence;

import com.bootcamp.store.application.dto.CartItemDTO;
import com.bootcamp.store.application.dto.ItemDTO;
import com.bootcamp.store.domain.entity.CartItem;
import com.bootcamp.store.domain.entity.ShoppingCart;
import com.bootcamp.store.domain.entity.UserProfile;
import com.bootcamp.store.domain.persistence.ShoppingCartPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class ShoppingCartPersistenceImpl implements ShoppingCartPersistence {

    private final ShoppingCartRepository cartRepository;

    @Autowired
    public ShoppingCartPersistenceImpl(ShoppingCartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public Optional<ShoppingCart> getShoppingCartById(Long id) {
        Optional<ShoppingCart> shoppingCartOptional = this.cartRepository.findById(id);
        if (shoppingCartOptional.isPresent()){
            List<CartItem> cartItemList = shoppingCartOptional.get().getCartItems().stream().toList();
            shoppingCartOptional.get().setCartItems(cartItemList);
        }
        return shoppingCartOptional;
    }

    @Override
    public ShoppingCart createShoppingCartByUserId(Long userId) {
        ShoppingCart cart = new ShoppingCart();
        cart.setUser(new UserProfile());
        cart.getUser().setId(userId);
        return cartRepository.save(cart);
    }

    @Override
    public Optional<ShoppingCart> getShoppingCartByUserId(Long userId) {
        UserProfile user = new UserProfile();
        user.setId(userId);
        return cartRepository.findByUser(user);
    }

    @Override
    public ShoppingCart addItemToCartByUserId(Long userId, CartItem cartItem) {
        Optional<ShoppingCart> cart = getShoppingCartByUserId(userId);
        if (cart.isPresent()){
            if (!cart.get().getCartItems().contains(cartItem)){
                cart.get().getCartItems().add(cartItem);
                cartRepository.save(cart.get());

            }
            return saveCart(cart.get());
        }
        return new ShoppingCart();
    }

    private ShoppingCart saveCart(ShoppingCart shoppingCart) {
        return null;
    }
}
