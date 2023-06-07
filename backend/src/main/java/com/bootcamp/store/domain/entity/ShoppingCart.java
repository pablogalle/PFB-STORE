package com.bootcamp.store.domain.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shoppingcarts")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cartSequence")
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserProfile user;

    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItems;
}
