package com.revature.models.DTOs;

//This is a Data Transfer Object, or DTO
//DTOs are often used to model data that is sent between client and server
//We need this to do things like obfuscate passwords
//You can also do this with a User constructor with no password
//Using a DTO just modularizes data further
//Check the videogame DTOs for more interesting uses of DTOs


public class OutgoingUserDTO {

    private int userId;
    private String username;
    private String role;

    public OutgoingUserDTO() {

    }

    public OutgoingUserDTO(int userId, String username, String role) {
        this.userId = userId;
        this.username = username;
        this.role = role;
    }

}
