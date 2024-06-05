package com.pfe.hostelmangement.services.imp;

import com.pfe.hostelmangement.dtos.RestaurantDto;
import com.pfe.hostelmangement.entities.RestaurantEntity;
import com.pfe.hostelmangement.mapper.ObjectMapper;
import com.pfe.hostelmangement.repositories.RestaurantRepository;
import com.pfe.hostelmangement.services.RestaurantServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RestaurantServicesImpl implements RestaurantServices {
    private final RestaurantRepository restaurantRepository;
    @Override
    public RestaurantDto save(RestaurantDto restaurantDto) {
        RestaurantEntity restaurant = ObjectMapper.map(restaurantDto, RestaurantEntity.class);
        RestaurantEntity entity = restaurantRepository.save(restaurant);
        return ObjectMapper.map(entity, RestaurantDto.class);
    }

    @Override
    public RestaurantDto findById(Long id) {
        Optional<RestaurantEntity> restaurant = restaurantRepository.findById(id);
        return restaurant.map(restaurantEntity -> ObjectMapper.map(restaurantEntity, RestaurantDto.class)).orElse(null);
    }

    @Override
    public List<RestaurantDto> findAll() {
        List<RestaurantEntity> all = restaurantRepository.findAll();
        return ObjectMapper.mapAll(all, RestaurantDto.class);
    }

    @Override
    public void delete(Long id) {
        restaurantRepository.deleteById(id);
    }
}
