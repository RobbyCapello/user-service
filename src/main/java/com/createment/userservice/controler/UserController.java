package com.createment.userservice.controler;

import com.createment.userservice.model.UserDTO;
import com.createment.userservice.model.UserEntity;
import com.createment.userservice.repository.UserRepository;
import com.createment.userservice.service.UserService;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserRepository userRepository;
    private final UserService service;

    public UserController(UserRepository userRepository, UserService service) {
        this.userRepository = userRepository;
        this.service = service;
    }

    @GetMapping("/users")
    List<UserDTO> findAll() {
        return service.findAllUsers();
    }

    @GetMapping("/user/{id}")
    UserDTO findById(@PathVariable Long id) {
        return service.customFind(id);
    }

    @PostMapping("/user")
    UserDTO save(@RequestBody UserDTO userDTO){
        return service.save(userDTO);
    }

    @DeleteMapping("/user/{username}")
    void delete(@PathVariable String username){
    service.delete(username);
    }
}
