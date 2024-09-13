package com.instagram.mock.service;

import com.instagram.mock.entity.Post;
import com.instagram.mock.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService{

    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Override
    public Post save(Post post) {
        postRepository.save(post);
        return null;
    }
}
