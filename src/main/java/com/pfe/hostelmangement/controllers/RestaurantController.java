package com.pfe.hostelmangement.controllers;


import com.pfe.hostelmangement.dtos.RestaurantDto;
import com.pfe.hostelmangement.services.imp.RestaurantServicesImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
@AllArgsConstructor
public class RestaurantController {
    private RestaurantServicesImpl restaurantServices;
    @GetMapping("/all")
    public ResponseEntity<List<RestaurantDto>> allRestaurants(){
        return ResponseEntity.ok(restaurantServices.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDto> findById(@PathVariable Long id){
        return new ResponseEntity<>(restaurantServices.findById(id), HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<RestaurantDto> save(@RequestBody RestaurantDto restaurantDto){
        return new ResponseEntity<>(restaurantServices.save(restaurantDto),HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<RestaurantDto> update(@RequestBody RestaurantDto restaurantDto){
        return new ResponseEntity<>(restaurantServices.save(restaurantDto),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        restaurantServices.delete(id);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }


}
