package com.example.goodreads.data.dao;

import com.example.goodreads.common.model.UserDTO;

public interface IUserDAO {
    void registerNewUser(UserDTO userDTO);

    UserDTO getUserProfileDetails(String userName);

    void updateUserDetails(String userName, UserDTO userDTO);
}
