package com.pfe.hostelmangement.services;

import com.pfe.hostelmangement.dtos.RestaurantDto;

import java.util.List;

public interface RestaurantServices {
    RestaurantDto save(RestaurantDto restaurantDto);
    RestaurantDto findById(Long id);
    List<RestaurantDto> findAll();
    void delete(Long id);

}
