package com.example.goodreads.api.model.response;

import java.io.Serializable;

public class UserDetailsResponseModel implements Serializable {
    private static final long serialVersionUID = 2507213485178347715L;

    private String fullName;

    public UserDetailsResponseModel() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
