package com.pfe.hostelmangement.dtos;

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
    private BlogEntity blog;
    private UserEntity user;
}
