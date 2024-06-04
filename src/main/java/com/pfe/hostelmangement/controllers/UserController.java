package com.pfe.hostelmangement.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/test")
public class UserController {

    @GetMapping("/hello")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String hello() {
        return "Hello, World!";
    }
}
