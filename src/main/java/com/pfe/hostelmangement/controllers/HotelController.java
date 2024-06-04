package com.pfe.hostelmangement.controllers;

import com.pfe.hostelmangement.dtos.HotelDto;
import com.pfe.hostelmangement.services.imp.HotelServicesImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
@AllArgsConstructor
public class HotelController {
    private HotelServicesImpl hotelService;

    @GetMapping("/all")
    public List<HotelDto> allHotels(){
        return hotelService.findAll();
    }
    @GetMapping("/{id}")
    public HotelDto findById(@PathVariable Long id){
        return hotelService.findById(id);
    }
    @PostMapping("/save")
    public HotelDto save(@RequestBody HotelDto hotelDto){
        return hotelService.save(hotelDto);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        hotelService.delete(id);
    }
    @PutMapping("/update")
    public HotelDto update(@RequestBody HotelDto hotelDto){
        return hotelService.save(hotelDto);
    }
}
