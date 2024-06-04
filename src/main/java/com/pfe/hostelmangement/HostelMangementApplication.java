package com.pfe.hostelmangement;

import com.pfe.hostelmangement.entities.UserEntity;
import com.pfe.hostelmangement.enums.RoleEnum;
import com.pfe.hostelmangement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class HostelMangementApplication {

    public static void main(String[] args) {
        SpringApplication.run(HostelMangementApplication.class, args);
    }


//    @Bean
//    CommandLineRunner commandLineRunner(UserRepository userRepository) {
//        return args -> {
//
//            UserEntity user = UserEntity.builder()
//                    .username("user")
//                    .password(passwordEncoder.encode("user"))
//                    .fullName("adam doe")
//                    .Role(RoleEnum.ADMIN)
//                    .build();
//
//            userRepository.save(user);
//
//        };
//    }

}
