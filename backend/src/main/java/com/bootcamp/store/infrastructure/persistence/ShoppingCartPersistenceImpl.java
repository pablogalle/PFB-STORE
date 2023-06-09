package com.bootcamp.store.infrastructure.persistence;

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
    private final CartItemRepository cartItemRepository;

    @Autowired
    public ShoppingCartPersistenceImpl(ShoppingCartRepository cartRepository, CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    @Transactional
    public Optional<ShoppingCart> getShoppingCartById(Long id) {
        Optional<ShoppingCart> shoppingCartOptional = this.cartRepository.findById(id);
        if (shoppingCartOptional.isPresent()) {
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
        if (cart.isPresent()) {
            cartItem.setShoppingCart(cart.get());
            return saveCart(cart.get(), cartItem);
        }
        return new ShoppingCart();
    }

    @Override
    public void deleteItemFromCart(Long userId, Long cartItemId) {
        /*Optional<ShoppingCart> shoppingCart = getShoppingCartByUserId(userId);
        if (shoppingCart.isPresent()){
            shoppingCart.get().getCartItems().stream()
        }*/
        cartItemRepository.deleteById(cartItemId);
    }

    @Override
    public void asignQuantityToCartItem(Long userId, Long cartItemId, Integer quantity) {
        if (quantity <= 0) {
            deleteItemFromCart(userId, cartItemId);
            return;
        }

        Optional<ShoppingCart> shoppingCart = getShoppingCartByUserId(userId);
        if (shoppingCart.isPresent()) {
            List<CartItem> cartItemsList = shoppingCart.get().getCartItems();
            Optional<CartItem> item = cartItemsList.stream().filter(o -> o.getId().equals(cartItemId)).findFirst();
            if (item.isPresent()) {
                CartItem cartItem = item.get();
                cartItem.setQuantity(quantity);
                cartItemRepository.save(cartItem);

            }
        }
    }

    @Override
    public void updateUser(UserProfile updatedUserProfile) {
        Optional<ShoppingCart> shoppingCart = getShoppingCartById(updatedUserProfile.getShoppingCart().getId());
        if (shoppingCart.isPresent()){
            shoppingCart.get().setUser(updatedUserProfile);
            cartRepository.save(shoppingCart.get());
        }
    }

    private ShoppingCart saveCart(ShoppingCart shoppingCart, CartItem cartItem) {
        List<CartItem> cartItemList = shoppingCart.getCartItems();
        boolean containsItem = cartItemList.stream().anyMatch(o -> o.getItem().getId().equals(cartItem.getItem().getId()));
        if (!containsItem) {
            shoppingCart.getCartItems().add(cartItemRepository.save(cartItem));
        }
        return cartRepository.save(shoppingCart);
    }
}
