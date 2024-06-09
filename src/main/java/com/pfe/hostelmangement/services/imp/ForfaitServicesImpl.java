package com.pfe.hostelmangement.services.imp;

import com.pfe.hostelmangement.dtos.ForfaitDto;
import com.pfe.hostelmangement.dtos.HotelDto;
import com.pfe.hostelmangement.entities.ForfaitEntity;
import com.pfe.hostelmangement.entities.HotelEntity;
import com.pfe.hostelmangement.mapper.ObjectMapper;
import com.pfe.hostelmangement.repositories.ForfaitRepository;
import com.pfe.hostelmangement.services.ForfaitServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
@AllArgsConstructor
public class ForfaitServicesImpl implements ForfaitServices {
    private final ForfaitRepository forfaitRepository;
    @Override
    public ForfaitDto save(ForfaitDto forfaitDto) {
        byte[] decodedImage = null;
        if (forfaitDto.getImage() != null) {
            decodedImage = Base64.getDecoder().decode(forfaitDto.getImage());
        }
        forfaitDto.setImage(null);

        ForfaitEntity forfaitEntity = ObjectMapper.map(forfaitDto, ForfaitEntity.class);
        forfaitEntity.setImage(decodedImage);
        ForfaitEntity forfaitSaved = forfaitRepository.save(forfaitEntity);
        return ObjectMapper.map(forfaitSaved, ForfaitDto.class);
    }

    @Override
    public List<ForfaitDto> findAll() {
        List<ForfaitEntity> all = forfaitRepository.findAll();
        return all.stream().map(this::encodeAndMap).toList();
    }

    @Override
    public void delete(Long id) {
        forfaitRepository.deleteById(id);
    }

    @Override
    public ForfaitDto findById(Long id) {
        return forfaitRepository.findById(id).map(this::encodeAndMap).orElse(null);
    }

    private ForfaitDto encodeAndMap(ForfaitEntity entity){
        String encodedMainImage = null;

        if (entity.getImage() != null) {
            encodedMainImage = Base64.getEncoder().encodeToString(entity.getImage());
        }


        entity.setImage(null);

        ForfaitDto dto = ObjectMapper.map(entity, ForfaitDto.class);
        dto.setImage(encodedMainImage);
        return dto;

    }
}
