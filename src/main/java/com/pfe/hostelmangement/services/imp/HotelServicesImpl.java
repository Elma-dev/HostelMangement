package com.pfe.hostelmangement.services.imp;

import com.pfe.hostelmangement.dtos.HotelDto;
import com.pfe.hostelmangement.entities.HotelEntity;
import com.pfe.hostelmangement.mapper.ObjectMapper;
import com.pfe.hostelmangement.repositories.HotelRepository;
import com.pfe.hostelmangement.services.HotelServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HotelServicesImpl implements HotelServices {

    private final HotelRepository hotelRepository;

    @Override
    public HotelDto save(HotelDto hotel) {
        HotelEntity hotelEntity = ObjectMapper.map(hotel, HotelEntity.class);
        HotelEntity hotelSaved = hotelRepository.save(hotelEntity);
        return ObjectMapper.map(hotelSaved, HotelDto.class);
    }

    @Override
    public List<HotelDto> findAll() {
        List<HotelEntity> all = hotelRepository.findAll();
        return ObjectMapper.mapAll(all, HotelDto.class);
    }

    @Override
    public HotelDto findById(Long id) {
        Optional<HotelEntity> hotel = hotelRepository.findById(id);
        if (!hotel.isPresent()) {
            return null;
        }
        return ObjectMapper.map(hotel, HotelDto.class);
    }

    @Override
    public void delete(Long id) {
        hotelRepository.deleteById(id);
    }
}
