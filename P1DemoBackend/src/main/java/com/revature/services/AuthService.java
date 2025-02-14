package com.revature.services;

import com.revature.DAOs.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//The Service layer is where we put our business logic
//User input validation, Data manipulation/reformatting, User authentication, etc.
@Service //1 of 4 stereotype annotations (make a class a bean)
public class AuthService {

    //Services talk to DAOs, so let's autowire the UserDAO so we can use its methods
    private final UserDAO userDAO;

    @Autowired
    public AuthService(UserDAO userDAO){
        this.userDAO = userDAO;
        //Spring will create an instantiation of this DAO for us
    }

    

}
