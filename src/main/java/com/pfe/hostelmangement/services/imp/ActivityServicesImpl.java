package com.pfe.hostelmangement.services.imp;

import com.pfe.hostelmangement.dtos.ActivityDto;
import com.pfe.hostelmangement.entities.ActivityEntity;
import com.pfe.hostelmangement.mapper.ObjectMapper;
import com.pfe.hostelmangement.repositories.ActivityRepository;
import com.pfe.hostelmangement.services.ActivityServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ActivityServicesImpl implements ActivityServices {
    private ActivityRepository activityRepository;
    @Override
    public ActivityDto save(ActivityDto activityDto) {
        byte[] decodedImage = null;
        if (activityDto.getImage() != null) {
            decodedImage = Base64.getDecoder().decode(activityDto.getImage());
        }
        activityDto.setImage(null);

        ActivityEntity activity = ObjectMapper.map(activityDto, ActivityEntity.class);
        activity.setImage(decodedImage);
        ActivityEntity saved = activityRepository.save(activity);
        return ObjectMapper.map(saved, ActivityDto.class);
    }

    @Override
    public List<ActivityDto> findAll() {
        List<ActivityEntity> all = activityRepository.findAll();
        return all.stream().map(this::encodeAndMap).toList();
    }
    private ActivityDto encodeAndMap(ActivityEntity entity){
        String encodedMainImage = null;

        if (entity.getImage() != null) {
            encodedMainImage = Base64.getEncoder().encodeToString(entity.getImage());
        }


        entity.setImage(null);

        ActivityDto dto = ObjectMapper.map(entity, ActivityDto.class);
        dto.setImage(encodedMainImage);
        return dto;

    }

    @Override
    public void delete(Long id) {
        activityRepository.deleteById(id);
    }
    @Override
    public ActivityDto findById(Long id) {
        Optional<ActivityEntity> activity = activityRepository.findById(id);
        return activity.map(this::encodeAndMap).orElse(null);
    }
}
