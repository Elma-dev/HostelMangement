package com.pfe.hostelmangement.dtos;

import lombok.*;

import java.sql.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class BookingDto {

    private Long id;
    private String destination;
    private Date startDate;
    private Date endDate;
    private boolean isPaid;
    UserDto user;
    List<HotelDto> hotels;
    List<RestaurantDto> restaurants;
}
