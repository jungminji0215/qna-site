package com.jmj.qnasite.dto;

import com.jmj.qnasite.entity.Article;

public class ArticleForm {
    private String title;
    private String author;
    private  String content;

    public ArticleForm(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }

    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Article toEntity(){
        return new Article(null, title, author, content);
    }
}
