package com.createment.userservice;

import com.createment.userservice.exception.UserNotFoundException;
import com.createment.userservice.model.UserEntity;
import com.createment.userservice.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CustomRepositoryUnitTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void customFindShouldReturnUser(){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("test");
        userEntity.setFirstName("test");
        userEntity.setLastName("test");

       UserEntity savedUser = userRepository.save(userEntity);

        assertNotNull(userRepository.customFind(userEntity.getId()));
        assertEquals(savedUser.getUserName(),userRepository.customFind(userEntity.getId()).getUserName());

    }
    @Test
    public void customFindShouldReturnException(){
        assertThrows(UserNotFoundException.class,()->userRepository.customFind(110L));

    }
}
