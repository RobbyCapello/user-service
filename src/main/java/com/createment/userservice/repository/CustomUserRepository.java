package com.createment.userservice.repository;

import com.createment.userservice.model.UserEntity;

public interface CustomUserRepository {
    UserEntity customFind(Long id);
    UserEntity findByUserName (String username);
}
