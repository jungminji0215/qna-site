package com.jmj.qnasite.dto;

import com.jmj.qnasite.domain.article.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleDto {
    private Long id;
    private String title;
    private  String content;

    public Article toEntity(){
        return new Article(id, title, content);
    }
}
