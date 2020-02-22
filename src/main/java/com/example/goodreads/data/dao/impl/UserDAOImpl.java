package com.example.goodreads.data.dao.impl;

import com.example.goodreads.api.exception.UserNameDoesNotExistsException;
import com.example.goodreads.api.exception.UserNameExistsException;
import com.example.goodreads.common.model.UserDTO;
import com.example.goodreads.common.utils.AppConstants;
import com.example.goodreads.data.dao.IUserDAO;
import com.example.goodreads.data.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Repository
public class UserDAOImpl extends GenericDAOImpl<User> implements IUserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
        super(entityManager, User.class);
    }

    @Override
    public void registerNewUser(UserDTO userDTO) {
        try {
            getUserByyUserName(userDTO.getUserName());
            throw new UserNameExistsException(AppConstants.USER_NAME_EXISTS);
        } catch (UserNameDoesNotExistsException e){
            User user = new User();
            BeanUtils.copyProperties(userDTO, user);
            user.setSignedUpOn(LocalDateTime.now(ZoneId.systemDefault()));
            user.setLastUpdatedOn(LocalDateTime.now(ZoneId.systemDefault()));
            super.persist(user);
        }
    }

    @Override
    public UserDTO getUserProfileDetails(String userName) {
        User user = getUserByyUserName(userName);
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);

        return userDTO;
    }

    @Override
    public void updateUserDetails(String userName, UserDTO userDTO) {
        User user = getUserByyUserName(userName);
        user.setFullName(userDTO.getFullName());
    }


    private User getUserByyUserName(String userName) {
        TypedQuery<User> query = entityManager.createNamedQuery("query.User.findByUserName", User.class);
        query.setParameter("userName", userName);
        query.setLockMode(LockModeType.OPTIMISTIC);

        try {
            return query.getSingleResult();
        } catch (NoResultException ex) {
            throw new UserNameDoesNotExistsException(AppConstants.USER_NAME_NOT_EXISTS);
        }
    }
}
