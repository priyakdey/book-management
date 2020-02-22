package com.example.goodreads.service.impl;

import com.example.goodreads.common.model.UserDTO;
import com.example.goodreads.data.dao.IUserDAO;
import com.example.goodreads.service.IUserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserRegistrationService implements IUserRegistrationService {
    private IUserDAO userDAO;

    @Autowired
    public UserRegistrationService(IUserDAO userRegistrationDAO) {
        this.userDAO = userRegistrationDAO;
    }

    @Override
    public void registerNewUser(UserDTO userDTO) {
        this.userDAO.registerNewUser(userDTO);
    }
}
