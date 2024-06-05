package com.pfe.hostelmangement.services;

import com.pfe.hostelmangement.dtos.BlogDto;
import com.pfe.hostelmangement.dtos.GuideDto;

import java.util.List;

public interface GuideService {

    GuideDto save(GuideDto guideDto);
    GuideDto findById(Long id);
    List<GuideDto> findAll();
    void delete(Long id);
}
