package com.pfe.hostelmangement.controllers;

import com.pfe.hostelmangement.dtos.HotelDto;
import com.pfe.hostelmangement.services.imp.HotelServicesImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
@AllArgsConstructor
public class HotelController {
    private HotelServicesImpl hotelService;

    @GetMapping("/all")
    public ResponseEntity<List<HotelDto>> allHotels(){
        return new ResponseEntity<>(hotelService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<HotelDto> findById(@PathVariable Long id){
        return new ResponseEntity<>(hotelService.findById(id),HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<HotelDto> save(@RequestBody HotelDto hotelDto){

        return new ResponseEntity<>(hotelService.save(hotelDto),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        hotelService.delete(id);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<HotelDto> update(@RequestBody HotelDto hotelDto){
        return new ResponseEntity<>(hotelService.save(hotelDto),HttpStatus.OK);
    }
}
