package com.pfe.hostelmangement.dtos;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ActivityDto {
    private Long id;
    private String name;
    private String description;
    private String location;
    private String image;
}
