package com.createment.userservice.model;

public class UserDTO {

    String userName;
    String firstName;
    String lastname;

    public UserDTO(String userName, String firstName, String lastname) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastname = lastname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
