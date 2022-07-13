package com.createment.userservice.model;

import javax.persistence.*;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    String userName;
    String firstName;
    String lastName;

    public String getUserName() {
        return userName;
    }

    public Long getId() {
        return id;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserEntity() {
    }

    public UserEntity(String username, String firstName, String lastName) {
        this.userName = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
