package com.pfe.hostelmangement.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pfe.hostelmangement.entities.BlogEntity;
import com.pfe.hostelmangement.entities.UserEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CommentDto {

    private Long id;
    private String content;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private BlogEntity blog;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UserEntity user;
}
