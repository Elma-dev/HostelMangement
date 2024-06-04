package com.pfe.hostelmangement.dtos;

import jakarta.persistence.Enumerated;
import lombok.Builder;

@Builder
public class UserDto {

    private int id;
    private String fullName;
    private String username;
    @Enumerated()
    private String role;
}
