package com.nys.store.store_article.service.impl;

import com.nys.store.store_article.domain.Article;
import com.nys.store.store_article.domain.ArticleWrap;
import com.nys.store.store_article.mapper.ArticleMapper;
import com.nys.store.store_article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<Article> selectByHot(int i, int i1) {
        return articleMapper.selectByHot(i,i1);
    }

    @Override
    public Article selectById(int id) {
        return articleMapper.selectById(id);
    }
}
