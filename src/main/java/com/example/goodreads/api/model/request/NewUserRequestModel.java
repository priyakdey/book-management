package com.example.goodreads.api.model.request;

import com.example.goodreads.common.utils.AppConstants;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class NewUserRequestModel implements Serializable {
    private static final long serialVersionUID = 465044821143295027L;


    @NotBlank (message = AppConstants.VALID_USER_NAME_MESSAGE)
    @Size(min = 5, max = 10)
    private String userName;

    @NotBlank (message = AppConstants.VALID_NAME_MESSAGE)
    private String fullName;

    public NewUserRequestModel() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
