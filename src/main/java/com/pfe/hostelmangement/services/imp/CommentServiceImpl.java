package com.pfe.hostelmangement.services.imp;

import com.pfe.hostelmangement.dtos.CommentDto;
import com.pfe.hostelmangement.entities.BlogEntity;
import com.pfe.hostelmangement.entities.CommentEntity;
import com.pfe.hostelmangement.mapper.ObjectMapper;
import com.pfe.hostelmangement.repositories.CommentRepository;
import com.pfe.hostelmangement.services.BlogService;
import com.pfe.hostelmangement.services.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    final CommentRepository commentRepository;

    @Override
    public CommentDto save(CommentDto commentDto) {
        CommentEntity comment = ObjectMapper.map(commentDto, CommentEntity.class);
        CommentEntity commentEntity = commentRepository.save(comment);
        return ObjectMapper.map(commentEntity, CommentDto.class);
    }

    @Override
    public CommentDto findById(Long id) {
        Optional<CommentEntity> blog = commentRepository.findById(id);
        if (!blog.isPresent()) {
            return null;
        }
        return ObjectMapper.map(blog, CommentDto.class);
    }

    @Override
    public List<CommentDto> findAll() {
        List<CommentEntity> blogs = commentRepository.findAll();
        return ObjectMapper.mapAll(blogs, CommentDto.class);
    }

    @Override
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }
}
