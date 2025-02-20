package com.revature.controllers;

//AuthController? Think AUTHentication/AUTHorization
//I like to put account registration and login functionality here
//Controller should ONLY deal with HTTP

import com.revature.models.DTOs.LoginDTO;
import com.revature.models.DTOs.OutgoingUserDTO;
import com.revature.models.User;
import com.revature.services.AuthService;
import jakarta.servlet.http.HttpSession;
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

    //Login (POST request)
    @PostMapping("/login")
    public ResponseEntity<OutgoingUserDTO> login(@RequestBody LoginDTO loginDTO, HttpSession session) {

        //NOTE: We have an HttpSession coming in through parameters, implicitly included in every HTTP Request
        //Login is where we'll set it up
        //We have to explicitly set whats in the tokens using setAttribute
        //we'll set it up to use roles
        //session lives on the backend, but we can pass it to the frontend with a cookie

        //try to login (send the loginDTO to the service)
        OutgoingUserDTO loggedInUser = authService.login(loginDTO);
        //If anything goes wrong, the service throws an exception and our global Exception handler takes over

        //If we get here, the login was successful -- we can build up the User's session!
        //this is how we add things liek the role to the token
        session.setAttribute("userId", loggedInUser.getUserId());
        session.setAttribute("username", loggedInUser.getUsername());
        session.setAttribute("role", loggedInUser.getRole());


        //its really easy to access these values with getAttribute()
        System.out.println("User " + session.getAttribute("username") + " has logged in with role " + session.getAttribute("role"));


        /* WHY store all this info in a session?
         * Lets us store user info that can be used for checks throughout the app
         * Check that a users role is appropriate (eg. role.equals("admin"))
         * Personalize the app (use the user's name in HTTP responses to use them in the UI etc.)
         * Can be used to simplify our URLs!
         *      ex: use the stored userId in "findByXByUserId" methods instead of sending in path
         *          cleans up the URLS and secures them a bit more
         *          also secures the URLs -- if it defaults to the users stored id, its more secure
         *
         *
         * We can set a session timeout as well in the application.properties
         * Alternatively, we can set it using session.setMaxInactiveInterval
         *
         *
         *
         */


        //Return the User info to the client
        return ResponseEntity.ok(loggedInUser);
    }


}