package com.nys.crm.post.dao;

import com.nys.crm.post.domain.Post;

import java.util.List;
import java.util.Set;

public interface PostDao {
    List<Post> findAllPost();

    Set<Post> findPostByDepId(String depId);

    List<Post> findByPage(int begin, int size);

    int findCount();

    void addPost(Post post);

    Post findById(String postId);

    void updatePost(Post post);
}
