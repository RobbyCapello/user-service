package com.createment.userservice.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException (Long id){
        super("Cannot find user with ID: " + id);
    }
    public UserNotFoundException (String username){
        super("Cannot find user with ID: " + username);
    }
}
