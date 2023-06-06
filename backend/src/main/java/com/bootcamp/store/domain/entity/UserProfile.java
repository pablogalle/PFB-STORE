package com.bootcamp.store.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "users")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSequence")
    private long Id;

    @Column(length = 100, nullable = false, unique = true)
    @Size(min = 3, max = 100)
    private String username;

    @Column(length = 100, nullable = false)
    @Size(min = 3, max = 100)
    private String name;

    @Column(length = 100, nullable = false)
    @Size(min = 3, max = 100)
    private String apellidos;

    @Column(length = 9, nullable = false)
    @Size(min = 9, max = 9)
    private String telephoneNumber;

    @Column(length = 100, nullable = false, unique = true)
    @Size(min = 10, max = 100)
    private String email;

    @Column(length = 100, nullable = false)
    @Size(min = 5, max = 100)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "item_id")
    private List<Item> favouriteItems;


    public UserProfile() {
    }

    public List<Item> getFavouriteItems() {
        return favouriteItems;
    }

    public void setFavouriteItems(List<Item> favouriteItems) {
        this.favouriteItems = favouriteItems;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
