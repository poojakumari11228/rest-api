package com.lab1.lab1.repo.impl;

import com.lab1.lab1.dto.PostDto;
import com.lab1.lab1.domain.Post;
import java.util.List;
import java.util.ArrayList;
import com.lab1.lab1.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.modelmapper.ModelMapper;
import com.lab1.lab1.Util.ListMapper;

@Repository
public class PostRepoImpl implements PostRepo {


    private static List<Post> posts = new ArrayList<>();
    private static int id = 500;



    static{
        Post p1 = new Post(1,"Java","Java is an Object Oriented Language","Pooja Kumari");
        posts.add(p1);
        Post p2 = new Post(2,"OOP","Object Oriented Programming","Pooja Kumari");
        posts.add(p2);
    }

    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Post findById(int id) {
        return findPostById(id);
    }

    private Post findPostById(int id) {
        return posts.stream()
                .filter(x->x.getId()==id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Post post) {
        post.setId(++id);
        posts.add(post);
    }

    @Override
    public void deleteById(int id) {
        var post = findPostById(id);
        posts.remove(post);

    }

    @Override
    public void update(int id, Post post) {
        var p = findPostById(id);
        posts.remove(p);
        p.setAuthor(post.getAuthor());
        p.setTitle(post.getTitle());
        p.setContent(post.getContent());
        posts.add(p);

    }


}
