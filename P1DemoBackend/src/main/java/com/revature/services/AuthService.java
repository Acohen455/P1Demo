package com.revature.services;

//The service layer is where we implement business logic
//What is business logic?
//User input validation, data manipulation/reformatting, etc.

//Since the controller ONLY should deal with HTTP we can do validation here in the service layer


import com.revature.DAOs.UserDAO;
import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    //Services talk to DAOs, so let's autowire the UserDAO so we can use its methods
    //If we autowire here, we break encapsulation
    private final UserDAO userDao;

    //this creates an instance of the UserDAO bean and passes it to the auth service
    //this IS the constructor
    //spring uses this constructor, creates a userDAO, and inserts it in when we use this
    //we dont need to externally pass a DAO
    //spring will create a DAO for us and pass it (ie. it's injected by spring not us)
    //it also creates an implementation of the interface for us so we dont have to
    //as soon as we boot up the auth service, spring does all this
    //we also can't just instantiate the DAO ourselves because its an interface
    @Autowired
    public AuthService(UserDAO userDao) {
        this.userDao = userDao; //spring will automatically create an instantiation of this DAO for us here
    }

    //This method will take a user object and send it to the DAO
    //It will also return the inserted User to the Controller
    public User registerUser(User user) {
        //TODO: implement input validation

        //we use the save() method to insert data into the DB
        //save() is one of the methods inherited from JPARepository
        //this is part of why we use it, dont have to write this ourself

        //save returns the user object -- save returns whatever is inserted into the database
        return userDao.save(user);


    };

}
