package com.pfe.hostelmangement;

import com.pfe.hostelmangement.entities.*;
import com.pfe.hostelmangement.enums.RoleEnum;
import com.pfe.hostelmangement.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.util.ArrayList;

@SpringBootApplication
@AllArgsConstructor
public class HostelManagementApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(HostelManagementApplication.class, args);
    }

    UserRepository userRepository;
    BookingRepository bookingRepository;
    HotelRepository hotelRepository;
    RestaurantRepository restaurantRepository;
    BlogRepository blogRepository;
    CommentRepository commentRepository;


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


        BlogEntity blog = BlogEntity.builder()
                .title("blog 1")
                .content("Hello World")
                .user(user)
                .build();

        blogRepository.save(blog);
        CommentEntity comment = CommentEntity.builder()
                .content("Nice ...")
                .blog(blog)
                .user(user)
                .build();

        commentRepository.save(comment);
    }
}
