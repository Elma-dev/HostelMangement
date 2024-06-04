package com.pfe.hostelmangement.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pfe.hostelmangement.entities.CommentEntity;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BlogDto {

    private String title;
    private String content;
    private UserDto user;
    private List<CommentDto> comments;
}
