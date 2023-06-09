package com.bootcamp.store.infrastructure.rest;

import com.bootcamp.store.application.dto.ItemDTO;
import com.bootcamp.store.application.dto.ShoppingCartDTO;
import com.bootcamp.store.application.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ShoppingCartRestController {
    private ShoppingCartService cartService;

    @Autowired
    public ShoppingCartRestController(ShoppingCartService cartService){this.cartService = cartService;}

    @CrossOrigin
    @GetMapping(value = "/carts/{cartId}", produces = "application/json")
    ResponseEntity<ShoppingCartDTO> getCartById(@PathVariable Long cartId) {
        Optional<ShoppingCartDTO> cart = cartService.getShoppingCartById(cartId);
        if (cart.isPresent()) return new ResponseEntity<>(cart.get(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @GetMapping(value = "/users/{userId}/cart", produces = "application/json")
    ResponseEntity<ShoppingCartDTO> getCartByUserId(@PathVariable Long userId){
        Optional<ShoppingCartDTO> cartDTO = cartService.getShoppingCartByUserId(userId);
        if (cartDTO.isPresent()) return new ResponseEntity<>(cartDTO.get(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @CrossOrigin
    @PostMapping(value = "/users/{userId}/cart" ,consumes = "application/json", produces = "application/json")
    ResponseEntity<ShoppingCartDTO> createCartByUserId(@PathVariable Long userId){
        ShoppingCartDTO cart = cartService.createShoppingCartByUserId(userId);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/users/{userId}/cart/addItem", consumes = "application/json", produces = "application/json")
    ResponseEntity<ShoppingCartDTO> addItemToCart(@PathVariable Long userId, @RequestBody ItemDTO itemDTO){
        ShoppingCartDTO cart = cartService.addItemToCartByUserId(userId, itemDTO);
        if (cart.equals(new ShoppingCartDTO())) return new ResponseEntity<>(HttpStatus.CONFLICT);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }
    @CrossOrigin
    @DeleteMapping(value = "/users/{userId}/cart/{cartItemId}")
    ResponseEntity<?> deleteItemFromCartById(@PathVariable Long userId, @PathVariable Long cartItemId){
        this.cartService.deleteItemFromCart(userId, cartItemId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @PatchMapping(value = "/users/{userId}/cart/{cartItemId}/{quantity}")
    ResponseEntity<?> asignQuantityItemId(@PathVariable Long userId, @PathVariable Long cartItemId,@PathVariable Integer quantity){
        this.cartService.asignQuantityToCartItem(userId, cartItemId, quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
