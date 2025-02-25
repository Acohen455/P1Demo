package com.revature.services;

//The service layer is where we implement business logic
//What is business logic?
//User input validation, data manipulation/reformatting, etc.

//Since the controller ONLY should deal with HTTP we can do validation here in the service layer


import com.revature.DAOs.UserDAO;
import com.revature.models.DTOs.LoginDTO;
import com.revature.models.DTOs.OutgoingUserDTO;
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
    public OutgoingUserDTO registerUser(User user) {
        //TODO: implement input validation -- we'll do this on tuesday

        //we use the save() method to insert data into the DB
        //save() is one of the methods inherited from JPARepository
        //this is part of why we use it, dont have to write this ourself

        //save returns the user object -- save returns whatever is inserted into the database
        User returnedUser = userDao.save(user);



        //We need to convert the user to a userDTO before sending to the client
        //We don't want to send the password back to the client
        OutgoingUserDTO outUserDTO = new OutgoingUserDTO(
                returnedUser.getUserId(),
                returnedUser.getUsername(),
                returnedUser.getRole()
        );

        //now we can return the secure DTO
        return outUserDTO;


    };


    //Login -- takes a LoginDTO and uses those fields to try to get a User from the DAO
    public OutgoingUserDTO login(LoginDTO loginDTO) {


        //input validation time!
        //check for null or if it is an empty string or whitespace only
        if (loginDTO.getUsername() == null || loginDTO.getUsername().isBlank()){
            //can throw a custom exception here if you want
            throw new IllegalArgumentException("Username cannot be null or whitespace only");
        }

        //same input validation but for password
        if (loginDTO.getPassword() == null || loginDTO.getPassword().isBlank()){
            //can throw a custom exception here if you want
            throw new IllegalArgumentException("Password cannot be empty");
        }

        //TODO: could do more checks

        //Now we know the username and password are good...
        //Try to get a User from the DAO
        //.orElse lets us do something if the optional returns empty
        User returnedUser = userDao.findByUsernameAndPassword(loginDTO.getUsername(),
                                                                loginDTO.getPassword()).orElse(null);


        //orElse(null) is a convenient way to extract data (or null value) from an Optional
        //We could also use orElseThrow() to throw an exception outright instead of returning null

        //If no user is found (if returnedUser is null) throw an exception
        //we could customize it to say which is invalid
        //that's a security risk though
        if (returnedUser == null) {
            throw new IllegalArgumentException("Invalid Username or Password");
        }

        //If we get here, login was successful so return a user to the controller
        return new OutgoingUserDTO(returnedUser); //using our convenient constructor


    };



}
