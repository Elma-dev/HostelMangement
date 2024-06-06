package com.pfe.hostelmangement.services.imp;

import com.pfe.hostelmangement.dtos.BlogDto;
import com.pfe.hostelmangement.dtos.HotelDto;
import com.pfe.hostelmangement.entities.BlogEntity;
import com.pfe.hostelmangement.entities.HotelEntity;
import com.pfe.hostelmangement.mapper.ObjectMapper;
import com.pfe.hostelmangement.repositories.BlogRepository;
import com.pfe.hostelmangement.services.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BlogServiceImpl implements BlogService {

    final BlogRepository blogRepository;

    @Override
    public BlogDto save(BlogDto blogDto) {
        if(blogDto.getId()!=null){
            blogRepository.findById(blogDto.getId()).ifPresent(blogEntity -> {
                blogDto.setImage(Base64.getEncoder().encodeToString(blogEntity.getImage()));
                blogDto.setTitle(blogEntity.getTitle());
                blogDto.setContent(blogEntity.getContent());
            });
        }
        byte[] decodedImage = null;
        if (blogDto.getImage() != null) {
            decodedImage = Base64.getDecoder().decode(blogDto.getImage());
        }
        blogDto.setImage(null);
        BlogEntity blog = ObjectMapper.map(blogDto, BlogEntity.class);
        blog.setImage(decodedImage);
        BlogEntity blogEntity = blogRepository.save(blog);
        return ObjectMapper.map(blogEntity, BlogDto.class);
    }

    @Override
    public BlogDto findById(Long id) {
        Optional<BlogEntity> blog = blogRepository.findById(id);
        return blog.map(this::encodeAndMap).orElse(null);
    }

    @Override
    public List<BlogDto> findAll() {
        List<BlogEntity> blogs = blogRepository.findAll();
        return  blogs.stream().map(this::encodeAndMap).toList();
    }

    private BlogDto encodeAndMap(BlogEntity entity){
        String encodedMainImage = null;

        if (entity.getImage() != null) {
            encodedMainImage = Base64.getEncoder().encodeToString(entity.getImage());
        }


        entity.setImage(null);

        BlogDto dto = ObjectMapper.map(entity, BlogDto.class);
        dto.setImage(encodedMainImage);
        return dto;

    }

    @Override
    public void delete(Long id) {
        blogRepository.deleteById(id);
    }
}
