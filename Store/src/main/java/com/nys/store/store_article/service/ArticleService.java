package com.nys.store.store_article.service;

import com.nys.store.store_article.domain.Article;

import java.util.List;

public interface ArticleService {
    List<Article> selectByHot(int i, int i1);

    Article selectById(int id);
}
