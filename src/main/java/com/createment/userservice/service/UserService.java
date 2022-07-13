package com.createment.userservice.service;

import com.createment.userservice.exception.ConstraintViolation;
import com.createment.userservice.model.UserDTO;
import com.createment.userservice.model.UserEntity;
import com.createment.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserEntity customFind;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> findAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        List<UserDTO> userDTO = users.stream().map(u -> new UserDTO(u.getUserName(), u.getFirstName(), u.getLastName())).collect(Collectors.toList());
    return userDTO;
    }


    public UserDTO customFind(Long id) {
        UserEntity userEntity = userRepository.customFind(id);
        return new UserDTO(userEntity.getUserName(), userEntity.getFirstName(), userEntity.getLastName());
    }

    public UserDTO save(UserDTO userDTO) {
        try {
            UserEntity userEntity = new UserEntity(userDTO.getUserName(), userDTO.getFirstName(), userDTO.getLastname());
            userEntity = userRepository.save(userEntity);
            return new UserDTO(userEntity.getUserName(),userEntity.getFirstName(), userEntity.getLastName());
        } catch (Exception e) {
            throw new ConstraintViolation(e.getMessage());
        }
    }

    public void delete(String username) {
        UserEntity userEntity = userRepository.findByUserName(username);
        userRepository.deleteById(userEntity.getId());
    }
}
