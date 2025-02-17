package com.revature.services;

import com.revature.DAOs.UserDAO;
import com.revature.models.DTOs.OutgoingUserDTO;
import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//anything to do with users goes here except for login/registration which goes in auth
@Service //beanify it
public class UserService {

        //Autowire the DAO so we can use its methods
        private final UserDAO userDAO;


        @Autowired
        public UserService(UserDAO userDAO) {
                this.userDAO = userDAO;
        }


        //Get all users from the DB
        public List<OutgoingUserDTO> getAllUsers() {
                //findAll() is a method we inherited from JpaRepository<User>
                //No user input from get all, so we don't have to do input validation
                List<User> returnedUsers = userDAO.findAll(); //returns a list of users

                //convert the users into a List of UserDTOs
                //We're going to use our special User args constructor from the DTO
                List<OutgoingUserDTO> userDTOs = new ArrayList<>();

                //loop through the users and convert them to UserDTOs
                //we could also do this with a stream
                //enhanced fors are more efficient than a stream for small collections
                //streams are better for large collections due to the ability to parallelize them
                for (User user : returnedUsers) {
                        userDTOs.add(new OutgoingUserDTO(user));
                }

                return userDTOs;
            }


}
