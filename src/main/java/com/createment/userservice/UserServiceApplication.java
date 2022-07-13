package com.createment.userservice;

import com.createment.userservice.model.UserEntity;
import com.createment.userservice.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

	@Bean
	CommandLineRunner initDatabase(UserRepository userRepository){
		return args -> {
			userRepository.save(new UserEntity("Sticks","Robby","Capello"));
			userRepository.save(new UserEntity("Nijntje","Marjolein","Gonlag"));
		};
	}

}
