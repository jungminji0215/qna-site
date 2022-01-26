package com.jmj.qnasite.dto;

import com.jmj.qnasite.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {
    private String title;
    private String author;
    private  String content;

    public Article toEntity(){
        return new Article(null, title, author, content);
    }
}
