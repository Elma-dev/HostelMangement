package com.pfe.hostelmangement.controllers;

import com.pfe.hostelmangement.dtos.UserDto;
import com.pfe.hostelmangement.entities.UserEntity;
import com.pfe.hostelmangement.mapper.ObjectMapper;
import com.pfe.hostelmangement.repositories.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/web")
public class AuthController {

    private final UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam("username") String username,
                                @RequestParam("password") String password,
                                HttpSession session) {
        UserEntity userEntity = userRepository.findByUsername(username);

        if (userEntity == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } else if (!userEntity.getPassword().equals(password)) {
            return new ResponseEntity<>("Username or Password incorrect",HttpStatus.UNAUTHORIZED);
        }

        session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.createEmptyContext());
        return new ResponseEntity<>( ObjectMapper.map(userEntity, UserDto.class), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto userEntity) {

        if (userRepository.findByUsername(userEntity.getUsername()) != null) {
            return new ResponseEntity<>("Username already exists", HttpStatus.CONFLICT);
        }

        userRepository.save(ObjectMapper.map(userEntity, UserEntity.class));
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
