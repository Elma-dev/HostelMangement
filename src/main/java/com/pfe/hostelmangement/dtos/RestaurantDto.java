package com.pfe.hostelmangement.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RestaurantDto {
    private Long id;
    private String name;
    private String location;
    private String cuisine;
    private float price;
    private float rating;
}
