package com.revature.models.DTOs;

//This is a Data Transfer Object, or DTO
//DTOs are often used to model data that is sent between client and server
//We need this to do things like obfuscate passwords
//You can also do this with a User constructor with no password
//Using a DTO just modularizes data further
//Check the videogame DTOs for more interesting uses of DTOs


import com.revature.models.User;

public class OutgoingUserDTO {

    private int userId;
    private String username;
    private String role;

    public OutgoingUserDTO() {

    }

    //this works instead of running these manually when initializing the userDTO
    //also much cleaner
    //see this in use in get all users in UserService
    public OutgoingUserDTO(User user) {
        this.userId = user.getUserId();
        this.username = user.getUsername();
        this.role = user.getRole();
    }

    public OutgoingUserDTO(int userId, String username, String role) {
        this.userId = userId;
        this.username = username;
        this.role = role;
    }


    //getters and setters

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //toString

    @Override
    public String toString() {
        return "OutgoingUserDTO{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
