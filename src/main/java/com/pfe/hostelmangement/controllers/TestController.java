package com.pfe.hostelmangement.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/web")
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}
