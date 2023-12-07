package com.salesmanager.sales.controllers;

import com.salesmanager.sales.Models.GenericeResponse;
import com.salesmanager.sales.entity.UserEntity;
import com.salesmanager.sales.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;


    @PostMapping("/login")
    public ResponseEntity<Object> login (@RequestBody UserEntity user) {
        GenericeResponse response = new GenericeResponse();
        ResponseEntity responseEntity = null;
        UserEntity userDetails = userService.validateUser(user);
        if (userDetails != null) {
            response.setStatus(true);
            response.setResponse(userDetails);
            responseEntity = new ResponseEntity<Object>(response, HttpStatus.ACCEPTED);
        } else {
            response.setStatus(false);
            response.setResponse("Invalid User");
            responseEntity = new ResponseEntity<Object>(response, HttpStatus.UNAUTHORIZED);
        }
        return responseEntity;
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register (@RequestBody UserEntity user) {
        GenericeResponse response = new GenericeResponse();
        ResponseEntity responseEntity = null;
        UserEntity userDetails = userService.registerUser(user);
        if (userDetails != null) {
            response.setStatus(true);
            response.setResponse(userDetails);
            responseEntity = new ResponseEntity<Object>(response, HttpStatus.ACCEPTED);
        } else {
            response.setStatus(false);
            response.setResponse("Invalid User");
            responseEntity = new ResponseEntity<Object>(response, HttpStatus.UNAUTHORIZED);
        }
        return responseEntity;
    }
}
