package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<User>> getAllUsers() {
        //lets return the users in a one liner
        return ResponseEntity.ok(userService.getAllUsers());
    }

}
