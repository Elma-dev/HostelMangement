package com.pfe.hostelmangement.controllers;


import com.pfe.hostelmangement.dtos.RestaurantDto;
import com.pfe.hostelmangement.services.imp.RestaurantServicesImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
@AllArgsConstructor
public class RestaurantController {
    private RestaurantServicesImpl restaurantServices;
    @GetMapping("/all")
    public List<RestaurantDto> allRestaurants(){
        return restaurantServices.findAll();
    }

    @GetMapping("/{id}")
    public RestaurantDto findById(@PathVariable Long id){
        return restaurantServices.findById(id);
    }
    @PostMapping("/save")
    public RestaurantDto save(@RequestBody RestaurantDto restaurantDto){
        return restaurantServices.save(restaurantDto);
    }
    @PutMapping("/update")
    public RestaurantDto update(@RequestBody RestaurantDto restaurantDto){
        return restaurantServices.save(restaurantDto);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        restaurantServices.delete(id);
    }


}
