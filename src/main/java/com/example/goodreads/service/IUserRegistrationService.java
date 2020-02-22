package com.example.goodreads.service;

import com.example.goodreads.common.model.UserDTO;

public interface IUserRegistrationService {

    void registerNewUser(UserDTO userDTO);
}
