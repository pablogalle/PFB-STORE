package com.bootcamp.store.application.dto;

import java.io.Serializable;

public class UserAuthDTO implements Serializable {
    private String username;
    private String password;

    public UserAuthDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
