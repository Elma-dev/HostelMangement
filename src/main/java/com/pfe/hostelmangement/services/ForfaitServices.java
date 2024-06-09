package com.pfe.hostelmangement.services;

import com.pfe.hostelmangement.dtos.ActivityDto;
import com.pfe.hostelmangement.dtos.ForfaitDto;

import java.util.List;

public interface ForfaitServices {
    ForfaitDto save(ForfaitDto forfaitDto);
    List<ForfaitDto> findAll();
    void delete(Long id);

    ForfaitDto findById(Long id);
}
