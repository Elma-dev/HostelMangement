package com.pfe.hostelmangement.controllers;

import com.pfe.hostelmangement.dtos.BookingDto;
import com.pfe.hostelmangement.dtos.CommentDto;
import com.pfe.hostelmangement.services.imp.CommentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private CommentServiceImpl commentService;

    @GetMapping("/all")
    public ResponseEntity<List<CommentDto>> allBookings(){

        return new ResponseEntity<>(commentService.findAll(),HttpStatus.OK);
    }
    @GetMapping("/delete/{id}")
    public  ResponseEntity<Boolean> delete(Long id){
        commentService.delete(id);
        return new ResponseEntity<Boolean>(true,HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<CommentDto> save(@RequestBody CommentDto commentDto){
        return  new ResponseEntity<>(commentService.save(commentDto),HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<CommentDto> update(@RequestBody CommentDto commentDto){
        return new ResponseEntity<>(commentService.save(commentDto),HttpStatus.OK);
    }


}
