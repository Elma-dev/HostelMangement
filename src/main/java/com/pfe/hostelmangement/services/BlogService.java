package com.pfe.hostelmangement.services;

import com.pfe.hostelmangement.dtos.BlogDto;

import java.util.List;

public interface BlogService {

    BlogDto save(BlogDto blogDto);
    BlogDto findById(Long id);
    List<BlogDto> findAll();
    void delete(Long id);
}
