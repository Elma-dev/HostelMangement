package com.pfe.hostelmangement.dtos;

import com.pfe.hostelmangement.entities.ActivityEntity;
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
    private int numberOfPersons;
    private String message;
    private boolean isPaid;
    private float totalPrice;
    private UserDto user;
    private List<HotelDto> hotels;
    private List<GuideDto> guides;
    private List<RestaurantDto> restaurants;
    private List<ActivityDto> activities;

}
