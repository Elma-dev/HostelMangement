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
    private boolean isPaid;
    @ManyToOne
    private UserEntity user;
    @OneToMany
    private List<HotelEntity> hotels;
    @OneToMany
    private List<RestaurantEntity> restaurants;
}
