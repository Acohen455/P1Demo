package com.revature.aspects;

import jakarta.servlet.http.HttpSession;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect //This class is an ASPECT -- a class that can trigger functionality at any point in our app runtime
//When a certain method is called, this class can listen for that invocation and trigger some functionality
//Low overhead because it listens for a specific thing to happen, instead of a category of things
@Component
public class AuthAspect {

    //2 use cases we'll see
    //1) When any method in a controller OTHER than AuthController is called, make sure the user is logged in
    //2) When any method that's annotated with our custom @AdminOnly annotation is called,
    //...make sure the user is an admin

    //@Before allows us to invoke this method BEFORE any method we specify
    //This says
    //Invoked the login check before any method in the controllers package BESIDES the AuthController
    @Order(1)
    @Before("within(com.revature.controllers.*) && !within(com.revature.controllers.AuthController)")
    public void checkLoggedIn(){

        //get access to the session (or lack thereof)
        //we start by yoinking the attributes of the session context
        ServletRequestAttributes attributes =
                    (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpSession session = attributes.getRequest().getSession(false); //false means don't create a new session if one doesn't exist

        //we're getting an object that has the session, and then trying to extract that session
        //getSession(false) means a session wont get created if it doesnt exist

        //if the session is null, the user is not logged in and we can throw an exception
        if(session == null || session.getAttribute("userId") == null) {
            throw new IllegalArgumentException("User must be logged in to do this!");
        }




    }

    //Before any method annotation with @AdminOnly, check user is admin
    //if we want to make this properly modular, we can get rid of the seperate adminonly file
    //this means we have to use regex the way we did in our other @Before
    @Order(2)
    @Before("@annotation(com.revature.aspects.AdminOnly)")
    public void checkAdmin() {


        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpSession session = attributes.getRequest().getSession(false);

        //check for session
        //if the session is null, the user is not logged in and we can throw an exception
        if(session == null || session.getAttribute("userId") == null) {
            throw new IllegalArgumentException("User must be logged in to do this!");
        }


        session.getAttribute("role");
        String role = session.getAttribute("role").toString();

        //just to see:
        System.out.println(session.getAttribute("role").toString());


        //If the User's role != "admin", throw an exception
        if(!role.equals("admin")) {
            throw new IllegalArgumentException("You must be an admin to do this!");
        }
    }


}
