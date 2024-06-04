package com.pfe.hostelmangement.services;

import com.pfe.hostelmangement.dtos.BookingDto;
import com.pfe.hostelmangement.dtos.HotelDto;

import java.util.List;

public interface BookingServices {
    BookingDto save(BookingDto bookingDto);
    List<BookingDto> findAll();
    List<BookingDto> userBookings(Long userId);
    void delete(Long id);
}
