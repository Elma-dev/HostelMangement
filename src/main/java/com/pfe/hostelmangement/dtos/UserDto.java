package com.pfe.hostelmangement.dtos;

import com.pfe.hostelmangement.enums.RoleEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String fullName;
    private RoleEnum Role;
}
