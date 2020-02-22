package com.example.goodreads.api.controller;

import com.example.goodreads.api.model.request.NewUserRequestModel;
import com.example.goodreads.common.model.UserDTO;
import com.example.goodreads.service.IUserRegistrationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/register",
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
public class NewUserRegistrationController {
    private IUserRegistrationService userRegistrationService;

    @Autowired
    public NewUserRegistrationController(IUserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    @PostMapping
    public ResponseEntity<Void> registerNewUser(@Valid @RequestBody NewUserRequestModel requestModel) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(requestModel, userDTO);
        userRegistrationService.registerNewUser(userDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
