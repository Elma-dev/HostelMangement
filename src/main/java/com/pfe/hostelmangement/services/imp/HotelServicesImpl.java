package com.pfe.hostelmangement.services.imp;

import com.pfe.hostelmangement.dtos.HotelDto;
import com.pfe.hostelmangement.entities.HotelEntity;
import com.pfe.hostelmangement.mapper.ObjectMapper;
import com.pfe.hostelmangement.repositories.HotelRepository;
import com.pfe.hostelmangement.services.HotelServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HotelServicesImpl implements HotelServices {

    private final HotelRepository hotelRepository;

    @Override
    public HotelDto save(HotelDto hotel) {
        byte[] decodedImage = null;
        if (hotel.getImage() != null) {
            decodedImage = Base64.getDecoder().decode(hotel.getImage());
        }
        hotel.setImage(null);

        HotelEntity hotelEntity = ObjectMapper.map(hotel, HotelEntity.class);
        hotelEntity.setImage(decodedImage);
        HotelEntity hotelSaved = hotelRepository.save(hotelEntity);
        return ObjectMapper.map(hotelSaved, HotelDto.class);
    }

    @Override
    public List<HotelDto> findAll() {
        List<HotelEntity> all = hotelRepository.findAll();
        return all.stream().map(this::encodeAndMap).toList();
    }
    private HotelDto encodeAndMap(HotelEntity entity){
        String encodedMainImage = null;

        if (entity.getImage() != null) {
            encodedMainImage = Base64.getEncoder().encodeToString(entity.getImage());
        }


        entity.setImage(null);

        HotelDto dto = ObjectMapper.map(entity, HotelDto.class);
        dto.setImage(encodedMainImage);
        return dto;

    }

    @Override
    public HotelDto findById(Long id) {
        Optional<HotelEntity> hotel = hotelRepository.findById(id);
        if (hotel.isEmpty()) {
            return null;
        }
        return encodeAndMap(hotel.get());
    }

    @Override
    public void delete(Long id) {
        hotelRepository.deleteById(id);
    }
}
