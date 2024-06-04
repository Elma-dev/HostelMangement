package com.pfe.hostelmangement.services;

import com.pfe.hostelmangement.dtos.HotelDto;
import com.pfe.hostelmangement.entities.HotelEntity;

import java.util.List;

public interface HotelServices {
    HotelDto save(HotelDto hotel);
    List<HotelDto> findAll();
    HotelDto findById(Long id);
    void delete(Long id);
}
