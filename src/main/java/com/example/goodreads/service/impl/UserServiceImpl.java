package com.example.goodreads.service.impl;

import com.example.goodreads.common.model.UserDTO;
import com.example.goodreads.data.dao.IUserDAO;
import com.example.goodreads.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
    private IUserDAO userDAO;

    @Autowired
    public UserServiceImpl(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDTO getUserProfileDetails(String userName) {
        return userDAO.getUserProfileDetails(userName);
    }

    @Override
    public void updateUserDetails(String userName, UserDTO userDTO) {
        userDAO.updateUserDetails(userName, userDTO);
    }
}
