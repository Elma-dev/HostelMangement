package com.pfe.hostelmangement.services.imp;

import com.pfe.hostelmangement.dtos.BookingDto;
import com.pfe.hostelmangement.entities.BookingEntity;
import com.pfe.hostelmangement.entities.UserEntity;
import com.pfe.hostelmangement.mapper.ObjectMapper;
import com.pfe.hostelmangement.repositories.BookingRepository;
import com.pfe.hostelmangement.repositories.UserRepository;
import com.pfe.hostelmangement.services.BookingServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookingServicesImpl implements BookingServices {
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    @Override
    public BookingDto save(BookingDto bookingDto) {
        BookingEntity booking = ObjectMapper.map(bookingDto, BookingEntity.class);
        bookingRepository.save(booking);
        return bookingDto;
    }

    @Override
    public List<BookingDto> findAll() {
        List<BookingEntity> all = bookingRepository.findAll();
        List<BookingDto> bookingDtos = ObjectMapper.mapAll(all, BookingDto.class);
        return bookingDtos;
    }

    @Override
    public List<BookingDto> userBookings(Long userId) {
        Optional<UserEntity> user = userRepository.findById(userId);
        if(user.isPresent()){
            List<BookingEntity> userBookings = bookingRepository.findByUser(user.get());
            return ObjectMapper.mapAll(userBookings, BookingDto.class);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        bookingRepository.deleteById(id);
    }
}
