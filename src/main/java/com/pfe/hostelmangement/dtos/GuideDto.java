package com.pfe.hostelmangement.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class GuideDto {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
}
