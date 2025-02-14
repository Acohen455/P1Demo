package com.revature.services;

//The service layer is where we implement business logic
//What is business logic?
//User input validation, data manipulation/reformatting, etc.


import com.revature.DAOs.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    //Services talk to DAOs, so let's autowire the UserDAO so we can use its methods
    private final UserDAO userDao;

    @Autowired
    public AuthService(UserDAO userDao) {
        this.userDao = userDao; //spring will automatically create an instantiation of this DAO for us here
    }


}
