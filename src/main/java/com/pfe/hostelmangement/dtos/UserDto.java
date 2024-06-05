package com.pfe.hostelmangement.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pfe.hostelmangement.enums.RoleEnum;
import lombok.*;

import java.util.List;

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
    private String email;
    private RoleEnum Role;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<BlogDto> blogs;
}
