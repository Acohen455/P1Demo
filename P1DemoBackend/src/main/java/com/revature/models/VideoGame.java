package com.revature.models;


import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "videogames")
public class VideoGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gameId;


    private String title;

    private String genre;


    //Foreign key connection to the users table PK
    //cascade defines how changes to user records will affect videogames records
    //Cascade.ALL means that any change to user will be reflected in dependent records
    //fetch defines when the videogames records will be fetched
    //FetchType.EAGER means that dependent records are loaded when the app starts
    //FetchType.LAZY means that dependent records are only loaded when they are needed
    //Join column is how we reference the PK of the users table
    //many to one indicates this is the foreign key
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user;

    //constructors

    public VideoGame() {
    }

    public VideoGame(int gameId, String title, String genre, User user) {
        this.gameId = gameId;
        this.title = title;
        this.genre = genre;
        this.user = user;
    }

    //getters and setters
    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //toString


    @java.lang.Override
    public java.lang.String toString() {
        return "VideoGame{" +
                "gameId=" + gameId +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", user=" + user +
                '}';
    }
}
