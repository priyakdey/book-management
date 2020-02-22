package com.example.goodreads.api.model.request;

import java.io.Serializable;

public class UserDetailsUpdateRequestModel implements Serializable {
    private static final long serialVersionUID = -6474600074568058061L;

    private String fullName;

    public UserDetailsUpdateRequestModel() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
