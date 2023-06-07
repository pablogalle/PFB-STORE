package com.bootcamp.store.application.dto;



import java.io.Serializable;
import java.util.List;

public class UserProfileDTO implements Serializable {
    private long Id;
    private String username;
    private String name;
    private String apellidos;
    private String telephoneNumber;
    private String email;
    private String password;
    private List<Long> favouriteItemsIds;

    public UserProfileDTO() {
    }

    public List<Long> getFavouriteItemsIds() {
        return favouriteItemsIds;
    }

    public void setFavouriteItemsIds(List<Long> favouriteItemsIds) {
        this.favouriteItemsIds = favouriteItemsIds;
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
