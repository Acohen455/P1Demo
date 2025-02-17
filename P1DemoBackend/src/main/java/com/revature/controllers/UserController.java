package com.revature.controllers;

import com.revature.models.DTOs.OutgoingUserDTO;
import com.revature.models.User;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //makes this class a bean and turns http response bodies into JSON
@RequestMapping("/users") //requests ending in /users will go here
public class UserController {

    //Autowire the userservice to use its methods
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }


    //return all users to the client
    @GetMapping
    public ResponseEntity<List<OutgoingUserDTO>> getAllUsers() {
        //lets return the users in a one liner
        //the parameter to .ok() is the RESPONSE BODY
        //AKA the data we're sending back
        return ResponseEntity.ok(userService.getAllUsers());
    }

}
