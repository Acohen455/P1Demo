package com.revature.controllers;


import com.revature.services.VideoGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games")
@CrossOrigin
public class VideoGameController {

    //autowire this
    private final VideoGameService gameService;


    @Autowired
    public VideoGameController(VideoGameService gameService) {
        this.gameService = gameService;
    }


    //A method that inserts a new game into the DB
    public ResponseEntity<VideoGame> insertGame(IncomingGameDTO gameDTO) {

    }

}
