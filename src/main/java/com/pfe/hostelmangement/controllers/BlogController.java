package com.pfe.hostelmangement.controllers;

import com.pfe.hostelmangement.dtos.BlogDto;
import com.pfe.hostelmangement.dtos.CommentDto;
import com.pfe.hostelmangement.services.imp.BlogServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/web/blog")
public class BlogController {
    private BlogServiceImpl blogService;

    @GetMapping("/all")
    public ResponseEntity<List<BlogDto>> allBookings(){

        return new ResponseEntity<>(blogService.findAll(),HttpStatus.OK);
    }
    @GetMapping("/delete/{id}")
    public  ResponseEntity<Boolean> delete(@PathVariable Long id){
        blogService.delete(id);
        return new ResponseEntity<Boolean>(true,HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<BlogDto> save(@RequestBody BlogDto comment){
        return  new ResponseEntity<>(blogService.save(comment),HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<BlogDto> update(@RequestBody BlogDto comment){
        return new ResponseEntity<>(blogService.save(comment),HttpStatus.OK);
    }


}
