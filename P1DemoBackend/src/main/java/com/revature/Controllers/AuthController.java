package com.revature.controllers;

//AuthController? Think AUTHentication/AUTHorization
//I like to put account registration and login functionality here
//Controller should ONLY deal with HTTP

import com.revature.models.DTOs.OutgoingUserDTO;
import com.revature.models.User;
import com.revature.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//What annotations do we need?
@RestController //combines @Controller and @ResponseBody (makes a class a bean, and lets us send JSON responses)
@RequestMapping("/auth") //this indicates that HTTP requests to the listed address land on this controller
@CrossOrigin
public class AuthController {

    //autowire the auth service to use its methods
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    //Insert a new user (POST request)
    //http://localhost:8080/auth/register
    @PostMapping("/register") //requests ending in /auth/register invoke this method
    public ResponseEntity<OutgoingUserDTO> registerUser(@RequestBody User user) { //requestbody retrieves data from the body of the request, here expecting user


        //This sends the user data to the service which sends it to the DAO and returns the user from the db
        OutgoingUserDTO returnedUser = authService.registerUser(user);

        //you can do a status code and use .build() on the responseentity if you dont need to return anything
        //you can also use .status(n).body() or .build()
        //.ok() sends a 200 OK status code and allows us to send a response body
        //we're going to send the user data back to the client instead of a status code
        return ResponseEntity.ok(returnedUser);

    }


}