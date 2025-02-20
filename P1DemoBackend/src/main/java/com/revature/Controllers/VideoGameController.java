package com.revature.controllers;


import com.revature.models.DTOs.IncomingGameDTO;
import com.revature.models.VideoGame;
import com.revature.services.VideoGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/games")
@CrossOrigin(value = "http://localhost:5173", allowCredentials = "true")
public class VideoGameController {

    //autowire this
    private final VideoGameService gameService;


    @Autowired
    public VideoGameController(VideoGameService gameService) {
        this.gameService = gameService;
    }


    //A method that inserts a new game into the DB
    @PostMapping
    public ResponseEntity<VideoGame> insertGame(@RequestBody IncomingGameDTO gameDTO) {

        //send the DTO to the service and returnt he VideoGame object that comes back
        return ResponseEntity.accepted().body(gameService.insertGame(gameDTO));
    }

}
