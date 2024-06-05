package com.pfe.hostelmangement.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class HotelDto {
    private Long id;
    private String name;
    private String location;
    private int rating;
    private String description;
    private String image;
    private float price;
}
