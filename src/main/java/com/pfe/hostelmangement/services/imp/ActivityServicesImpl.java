package com.pfe.hostelmangement.services.imp;

import com.pfe.hostelmangement.dtos.ActivityDto;
import com.pfe.hostelmangement.entities.ActivityEntity;
import com.pfe.hostelmangement.mapper.ObjectMapper;
import com.pfe.hostelmangement.repositories.ActivityRepository;
import com.pfe.hostelmangement.services.ActivityServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ActivityServicesImpl implements ActivityServices {
    private ActivityRepository activityRepository;
    @Override
    public ActivityDto save(ActivityDto activityDto) {
        ActivityEntity activity = ObjectMapper.map(activityDto, ActivityEntity.class);
        ActivityEntity saved = activityRepository.save(activity);
        return ObjectMapper.map(saved, ActivityDto.class);
    }

    @Override
    public List<ActivityDto> findAll() {
        List<ActivityEntity> all = activityRepository.findAll();
        return ObjectMapper.mapAll(all, ActivityDto.class);
    }

    @Override
    public void delete(Long id) {
        activityRepository.deleteById(id);
    }
}
