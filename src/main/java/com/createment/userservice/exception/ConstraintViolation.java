package com.createment.userservice.exception;

public class ConstraintViolation extends RuntimeException{
    public ConstraintViolation(String message){
        super(message);
    }
}
