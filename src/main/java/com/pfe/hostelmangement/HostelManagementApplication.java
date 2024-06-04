package com.pfe.hostelmangement;

import com.pfe.hostelmangement.entities.BookingEntity;
import com.pfe.hostelmangement.entities.HotelEntity;
import com.pfe.hostelmangement.entities.RestaurantEntity;
import com.pfe.hostelmangement.entities.UserEntity;
import com.pfe.hostelmangement.enums.RoleEnum;
import com.pfe.hostelmangement.repositories.BookingRepository;
import com.pfe.hostelmangement.repositories.HotelRepository;
import com.pfe.hostelmangement.repositories.RestaurantRepository;
import com.pfe.hostelmangement.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.util.ArrayList;

@SpringBootApplication
@AllArgsConstructor
public class HostelManagementApplication implements CommandLineRunner {

    UserRepository userRepository;
    BookingRepository bookingRepository;
    HotelRepository hotelRepository;
    RestaurantRepository restaurantRepository;

    public static void main(String[] args) {
        SpringApplication.run(HostelManagementApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        UserEntity user = UserEntity.builder()
                .fullName("admin")
                .username("admin")
                .password("admin")
                .role(RoleEnum.ADMIN)
                .build();
        userRepository.save(user);

        HotelEntity parisHotel = HotelEntity.builder()
                .name("Hotel 1")
                .location("Paris")
                .rating(5)
                .build();
        HotelEntity hotelEntity = hotelRepository.save(parisHotel);
        ArrayList<HotelEntity> hotels = new ArrayList<>();
        hotels.add(hotelEntity);

        RestaurantEntity restaurant = restaurantRepository.save(RestaurantEntity.builder()
                .name("Restaurant 1")
                .location("Paris")
                .cuisine("cuisine")
                .build());
        ArrayList<RestaurantEntity> restaurants = new ArrayList<>();
        restaurants.add(restaurant);

        BookingEntity parisBooking = BookingEntity.builder()
                .user(user)
                .destination("Paris")
                .startDate(new Date(2022, 12, 12))
                .endDate(new Date(2022, 12, 12))
                .hotels(hotels)
                .restaurants(restaurants)
                .build();
        bookingRepository.save(parisBooking);



    }
}
