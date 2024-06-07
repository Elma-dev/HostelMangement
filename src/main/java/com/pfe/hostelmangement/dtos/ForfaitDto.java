package com.pfe.hostelmangement.dtos;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ForfaitDto {

    private Long id;
    private String name;
    private float price;
    private int rating;
    private int duration;
    private int nbrPersons;
    private String description;
    private String location;
    private String image;
}
