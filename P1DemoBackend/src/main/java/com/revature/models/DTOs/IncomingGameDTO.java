package com.revature.models.DTOs;


//Here's another DTO - but we aren't leaving out a password or anything
//This time we want to make a cleaner request body (ie. payload) when inserting a new game
//Instead of passing the entire user, we can simply pass the UserId
//We're essentially tying the user to the game by a foreign key (the UserId)

//For this we need a full payloads of game info, since we're adding a new game
//We can use a second DTO with a cleaner payload for getting the game
//(just the IDs tying things together -- ie. userId and GameId)
//We can then fetch data for that on demand


public class IncomingGameDTO {

    private String title;
    private String genre;
    private int userId;


    //boilerplate


    public IncomingGameDTO(String title, String genre, int userId) {
        this.title = title;
        this.genre = genre;
        this.userId = userId;
    }



    //Getters and setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    //ToString
    @Override
    public String toString() {
        return "IncomingGameDTO{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", userId=" + userId +
                '}';
    }
}
