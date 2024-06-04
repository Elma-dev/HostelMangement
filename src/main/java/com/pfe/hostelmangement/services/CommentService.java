package com.pfe.hostelmangement.services;

import com.pfe.hostelmangement.dtos.CommentDto;

import java.util.List;

public interface CommentService {

    CommentDto save(CommentDto commentDto);
    CommentDto findById(Long id);
    List<CommentDto> findAll();
    void delete(Long id);
}
