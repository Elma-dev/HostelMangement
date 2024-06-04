package com.pfe.hostelmangement.entities;

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
    @ManyToOne
    private UserEntity user;
    @ManyToMany
    private List<HotelEntity> hotel;
    @ManyToMany
    private List<RestaurantEntity> restaurant;
}
