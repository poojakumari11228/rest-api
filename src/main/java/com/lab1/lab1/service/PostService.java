package com.lab1.lab1.service;

import com.lab1.lab1.dto.PostDto;
import java.util.List;
public interface PostService {
    List<PostDto> findAll();

    PostDto getById(int id);

    void savePost(PostDto postDto);

    void deleteById(int id);

    void updateById(int id, PostDto postDto);
}
