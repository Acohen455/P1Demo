package com.revature.services;


import com.revature.DAOs.UserDAO;
import com.revature.DAOs.VideoGameDAO;
import com.revature.models.DTOs.IncomingGameDTO;
import com.revature.models.User;
import com.revature.models.VideoGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VideoGameService {

    //Autowire the UserDAO and VideoGameDAO
    private final UserDAO userDAO;
    private final VideoGameDAO videoGameDAO;


    //constructor injection
    @Autowired
    public VideoGameService(UserDAO userDAO, VideoGameDAO videoGameDAO) {
        this.userDAO = userDAO;
        this.videoGameDAO = videoGameDAO;
    }


    //Insert a new game into the DB (get user by ID and make a game object with it)
    public VideoGame insertGame(IncomingGameDTO gameDTO) {


        //TODO: input validation


        //Skeleton VideoGame object first
        //0 for id since the DB will handle that
        //null for the user since we need to get it first
        //the data here will be pulled off the dto for title and genre
        //IF we use a wrapper class we can use null instead of 0 for the game ID
        //the game id actually isnt ever being used -- i dont personally like using 0 here
        //TODO: change game ID to null and use wrapper class for the gameId in com.revature.models.VideoGame
        VideoGame newGame = new VideoGame(
                0,
                gameDTO.getTitle(),
                gameDTO.getGenre(),
                null
        );

        //We need to use the userId from the DTO to get a User from the DB
        //findById() returns an optional
        Optional<User> user = userDAO.findById(gameDTO.getUserId());


        //if the user does not exist do something
        if(user.isEmpty()) {
            //TODO: throw an exception
        } else {
            //if the user exists we can set it in the game object
            newGame.setUser(user.get());
            //get() is how we extract data from an optional
        }


        return videoGameDAO.save(newGame);


    };



}
