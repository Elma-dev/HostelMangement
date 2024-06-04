package com.pfe.hostelmangement.services;

import com.pfe.hostelmangement.dtos.HotelDto;
import com.pfe.hostelmangement.entities.HotelEntity;

public interface HotelServices {
    HotelEntity save(HotelDto hotel);
}
