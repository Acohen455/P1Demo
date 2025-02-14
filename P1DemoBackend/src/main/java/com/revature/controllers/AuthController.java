package com.revature.controllers;

import com.revature.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//AuthController? Think AUTHentication/AUTHorization
//I like to put account registration and login functionality here
@RestController //Combines @Controller and @ResponseBody (makes a class a bean, and lets us send JSON responses)
@RequestMapping("/auth") //Requests ending in /auth will go to this Controller
public class AuthController {

    //TODO: autowire the AuthService

    //Insert a new user (POST request)
    @PostMapping("/register") //Requests ending in /auth/register will invoke this method
    public ResponseEntity<?> registerUser(@RequestBody User user){

        //TODO: actually implement this

        return ResponseEntity.ok("User registered (but not really)");
        //.ok() sends a 200 OK status code and allows us to send a response body
        
    }

}
