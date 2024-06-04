package com.pfe.hostelmangement.controllers;

import com.pfe.hostelmangement.dtos.BlogDto;
import com.pfe.hostelmangement.entities.BlogEntity;
import com.pfe.hostelmangement.mapper.ObjectMapper;
import com.pfe.hostelmangement.repositories.BlogRepository;
import com.pfe.hostelmangement.repositories.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/web")
public class HomeController {

    final BlogRepository blogRepository;
    final CommentRepository commentRepository;

    @GetMapping("/all")
    public ResponseEntity<?> getAllBlogs() {
        List<BlogEntity> blogs = blogRepository.findAll();
        return new ResponseEntity<>(ObjectMapper.mapAll(blogs, BlogDto.class), HttpStatus.OK);
    }
}
