package com.pfe.hostelmangement.dtos;

import com.pfe.hostelmangement.entities.BlogEntity;
import com.pfe.hostelmangement.entities.UserEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CommentDto {

    private Long id;
    private String content;
}
