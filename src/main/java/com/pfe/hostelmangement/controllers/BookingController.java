package com.pfe.hostelmangement.controllers;

import com.pfe.hostelmangement.dtos.BookingDto;
import com.pfe.hostelmangement.services.imp.BookingServicesImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/booking")
public class BookingController {
    private BookingServicesImpl bookingServices;

    @GetMapping("/all")
    public List<BookingDto> allBookings(){
        return bookingServices.findAll();
    }
    @GetMapping("/user/{userId}")
    public List<BookingDto> userBookings(@PathVariable Long userId){
        return bookingServices.userBookings(userId);
    }
    @GetMapping("/delete/{id}")
    public void delete(Long id){
        bookingServices.delete(id);
    }
    @PostMapping("/save")
    public BookingDto save(@RequestBody BookingDto bookingDto){
        return bookingServices.save(bookingDto);
    }
    @PutMapping("/update")
    public BookingDto update(@RequestBody BookingDto bookingDto){
        return bookingServices.save(bookingDto);
    }


}
