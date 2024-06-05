package com.pfe.hostelmangement.services;

import com.pfe.hostelmangement.dtos.ActivityDto;

import java.util.List;

public interface ActivityServices {
    ActivityDto save(ActivityDto activityDto);
    List<ActivityDto> findAll();
    void delete(Long id);

    ActivityDto findById(Long id);
}
