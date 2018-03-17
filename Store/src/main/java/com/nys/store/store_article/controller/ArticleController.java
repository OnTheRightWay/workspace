package com.nys.store.store_article.controller;

import com.nys.store.store_article.domain.Article;
import com.nys.store.store_article.domain.ArticleWrap;
import com.nys.store.store_article.domain.ArticlesWrap;
import com.nys.store.store_article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/selectByHot")
    public ArticlesWrap selectByHot(){
        List<Article> articles = articleService.selectByHot(1,6);
        return new ArticlesWrap(200,"success",articles);
    }

    @RequestMapping("/selectById")
    public ArticleWrap selectById(int id){
        Article article = articleService.selectById(id);
        return new ArticleWrap(200,"success",article);
    }
}
