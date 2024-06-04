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

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BlogServiceImpl implements BlogService {

    final BlogRepository blogRepository;

    @Override
    public BlogDto save(BlogDto blogDto) {
        BlogEntity blog = ObjectMapper.map(blogDto, BlogEntity.class);
        BlogEntity blogEntity = blogRepository.save(blog);
        return ObjectMapper.map(blogEntity, BlogDto.class);
    }

    @Override
    public BlogDto findById(Long id) {
        Optional<BlogEntity> blog = blogRepository.findById(id);
        if (!blog.isPresent()) {
            return null;
        }
        return ObjectMapper.map(blog, BlogDto.class);
    }

    @Override
    public List<BlogDto> findAll() {
        List<BlogEntity> blogs = blogRepository.findAll();
        return ObjectMapper.mapAll(blogs, BlogDto.class);
    }

    @Override
    public void delete(Long id) {
        blogRepository.deleteById(id);
    }
}
