package com.nys.crm.post.service;

import com.nys.crm.post.domain.Post;

import java.util.List;
import java.util.Set;

public interface PostService {
    Set<Post> findPostByDepId(String depId);

    List<Post> findAllByPage(int begin, int size);

    int findCount();

    void addPost(Post post);

    Post findPostById(String postId);

    void updatePost(Post post);

    List<Post> findAll();
}
