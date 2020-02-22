package com.example.goodreads.api.controller;

import com.example.goodreads.api.model.request.UserDetailsUpdateRequestModel;
import com.example.goodreads.api.model.response.UserDetailsResponseModel;
import com.example.goodreads.common.model.UserDTO;
import com.example.goodreads.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/{username}",
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    private IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<UserDetailsResponseModel>
                            getUserProfileDetails(@PathVariable("username") String userName) {
        UserDTO userProfileDetails = this.userService.getUserProfileDetails(userName);
        UserDetailsResponseModel responseModel = new UserDetailsResponseModel();
        BeanUtils.copyProperties(userProfileDetails, responseModel);

        return new ResponseEntity<>(responseModel, HttpStatus.FOUND);
    }

    @PutMapping
    public void updateUserDetails(@PathVariable("username") String userName,
                                  @Valid @RequestBody UserDetailsUpdateRequestModel requestModel) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(requestModel, userDTO);

        userService.updateUserDetails(userName, userDTO);
    }
}
