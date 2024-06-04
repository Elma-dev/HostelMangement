package com.pfe.hostelmangement.controllers;

import com.pfe.hostelmangement.dtos.BookingDto;
import com.pfe.hostelmangement.services.imp.BookingServicesImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/booking")
public class BookingController {
    private BookingServicesImpl bookingServices;

    @GetMapping("/all")
    public ResponseEntity<List<BookingDto>> allBookings(){

        return new ResponseEntity<List<BookingDto>>(bookingServices.findAll(),HttpStatus.OK);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BookingDto>> userBookings(@PathVariable Long userId){
        return new ResponseEntity<List<BookingDto>>(bookingServices.userBookings(userId),HttpStatus.OK);
    }
    @GetMapping("/delete/{id}")
    public  ResponseEntity<Boolean> delete(Long id){
        bookingServices.delete(id);
        return new ResponseEntity<Boolean>(true,HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<BookingDto> save(@RequestBody BookingDto bookingDto){
        return  new ResponseEntity<>(bookingServices.save(bookingDto),HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<BookingDto> update(@RequestBody BookingDto bookingDto){
        return new ResponseEntity<>(bookingServices.save(bookingDto),HttpStatus.OK);
    }


}
