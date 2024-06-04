package com.pfe.hostelmangement.dtos;

import com.pfe.hostelmangement.enums.RoleEnum;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserDto {
    private Long id;

    private String username;
    private String password;
    private String fullName;
    private RoleEnum Role;
}
