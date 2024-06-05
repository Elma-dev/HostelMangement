package com.pfe.hostelmangement.services.imp;

import com.pfe.hostelmangement.dtos.GuideDto;
import com.pfe.hostelmangement.entities.GuideEntity;
import com.pfe.hostelmangement.mapper.ObjectMapper;
import com.pfe.hostelmangement.repositories.GuideRepository;
import com.pfe.hostelmangement.services.GuideService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GuideServiceImpl implements GuideService {
    private GuideRepository guideRepository;
    @Override
    public GuideDto save(GuideDto guideDto) {
        GuideEntity guide = ObjectMapper.map(guideDto, GuideEntity.class);
        GuideEntity entity = guideRepository.save(guide);
        return ObjectMapper.map(entity, GuideDto.class);
    }

    @Override
    public GuideDto findById(Long id) {
        Optional<GuideEntity> byId = guideRepository.findById(id);
        return byId.map(guideEntity -> ObjectMapper.map(guideEntity, GuideDto.class)).orElse(null);
    }

    @Override
    public List<GuideDto> findAll() {
        List<GuideEntity> all = guideRepository.findAll();
        if (!all.isEmpty()) {
            return ObjectMapper.mapAll(all, GuideDto.class);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        guideRepository.deleteById(id);
    }
}
