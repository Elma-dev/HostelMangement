package com.pfe.hostelmangement.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class BookingEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String destination;
    private Date startDate;
    private Date endDate;
    private int numberOfPersons;
    private String message;
    private boolean isPaid;
    private float totalPrice;

    @ManyToOne
    private UserEntity user;
    @ManyToMany
    private List<HotelEntity> hotels;
    @ManyToMany
    private List<RestaurantEntity> restaurants;
    @ManyToMany
    private List<ActivityEntity> activities;
    @ManyToMany
    private List<GuideEntity> guide;
}
