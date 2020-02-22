package com.example.goodreads.service;

import com.example.goodreads.common.model.UserDTO;

public interface IUserService {
    UserDTO getUserProfileDetails(String userName);

    void updateUserDetails(String userName, UserDTO userDTO);
}
