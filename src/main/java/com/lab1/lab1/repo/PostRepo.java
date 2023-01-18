package com.lab1.lab1.repo;

import java.util.List;
import com.lab1.lab1.domain.Post;

public interface PostRepo{

    List<Post> findAll();
    Post findById(int id);

    void save(Post post);

    void deleteById(int id);

    void update(int id, Post post);
}
