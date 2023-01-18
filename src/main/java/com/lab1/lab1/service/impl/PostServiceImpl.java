package com.lab1.lab1.service.impl;

import com.lab1.lab1.service.PostService;
import com.lab1.lab1.dto.PostDto;
import java.util.List;
import org.springframework.stereotype.Service;
import com.lab1.lab1.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import com.lab1.lab1.Util.ListMapper;
import com.lab1.lab1.domain.Post;

@Service
@lombok.RequiredArgsConstructor
public class PostServiceImpl implements PostService {


    @Autowired
    private PostRepo postRepo;
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper listMapper;

    @Override
    public List<PostDto> findAll() {
        return listMapper.mapList(postRepo.findAll(), new PostDto());
    }

    @Override
    public PostDto getById(int id) {
        return modelMapper.map(postRepo.findById(id), new PostDto().getClass());
    }

    @Override
    public void savePost(PostDto postDto) {
        postRepo.save(modelMapper.map(postDto, Post.class));
    }

    @Override
    public void deleteById(int id) {
        postRepo.deleteById(id);
    }

    @Override
    public void updateById(int id, PostDto postDto) {
        postRepo.update(id, modelMapper.map(postDto, Post.class));
    }
}
