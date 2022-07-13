package com.createment.userservice.repository;

import com.createment.userservice.exception.UserNotFoundException;
import com.createment.userservice.model.UserEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class CustomUserRepositoryImpl implements CustomUserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserEntity customFind(Long id) {
        try {
            return (UserEntity) entityManager.createQuery("SELECT u FROM UserEntity u WHERE u.id = :id")
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception ex) {
            throw new UserNotFoundException(id);
        }
    }

    @Override
    public UserEntity findByUserName(String username) {
        try {
            return (UserEntity) entityManager.createQuery("SELECT u FROM UserEntity u WHERE u.username = :username")
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (Exception ex) {
            throw new UserNotFoundException(username);
        }
    }
}
