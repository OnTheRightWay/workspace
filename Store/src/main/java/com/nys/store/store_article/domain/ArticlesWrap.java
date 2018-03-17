package com.nys.store.store_article.domain;

import java.util.List;

public class ArticlesWrap {
    private int code;
    private String message;
    private List<Article> articles;

    public ArticlesWrap() {
    }

    public ArticlesWrap(int code, String message, List<Article> articles) {

        this.code = code;
        this.message = message;
        this.articles = articles;
    }

    public int getCode() {

        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "ArticlesWrap{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", articles=" + articles +
                '}';
    }
}
