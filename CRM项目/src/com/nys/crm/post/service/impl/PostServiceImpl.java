package com.nys.crm.post.service.impl;

import com.nys.crm.post.dao.PostDao;
import com.nys.crm.post.domain.Post;
import com.nys.crm.post.service.PostService;

import java.util.List;
import java.util.Set;

public class PostServiceImpl implements PostService {
    private PostDao postDao;

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public Set<Post> findPostByDepId(String depId) {
        if (depId==null||depId.equals("")){
            return null;
        }
        return postDao.findPostByDepId(depId);
    }

    @Override
    public List<Post> findAllByPage(int begin, int size) {
        return postDao.findByPage(begin,size);
    }

    @Override
    public int findCount() {
        return postDao.findCount();
    }

    @Override
    public void addPost(Post post) {
        postDao.addPost(post);
    }

    @Override
    public Post findPostById(String postId) {
        return postDao.findById(postId);
    }

    @Override
    public void updatePost(Post post) {
        postDao.updatePost(post);
    }

    @Override
    public List<Post> findAll() {
        return postDao.findAllPost();
    }
}
