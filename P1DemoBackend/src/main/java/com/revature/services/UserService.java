package com.revature.services;

import com.revature.DAOs.UserDAO;
import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        public List<User> getAllUsers() {
                //findAll() is a method we inherited from JpaRepository<User>
                //No user input from get all, so we don't have to do input validation
                return userDAO.findAll();
            }


}
