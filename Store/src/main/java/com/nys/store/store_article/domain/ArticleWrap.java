package com.nys.store.store_article.domain;

public class ArticleWrap {
    private int code;
    private String message;
    private Article article;

    public ArticleWrap() {
    }

    public ArticleWrap(int code, String message, Article article) {

        this.code = code;
        this.message = message;
        this.article = article;
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

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "ArticleWrap{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", article=" + article +
                '}';
    }
}
