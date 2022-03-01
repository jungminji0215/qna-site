package com.jmj.qnasite.service;

import com.jmj.qnasite.dto.ArticleDto;
import com.jmj.qnasite.domain.article.Article;

import java.util.List;

public interface ArticleService {

    public List<Article> index();

    public Article show(Long id);

    public Article create(ArticleDto dto);

    public Article update(Long id, ArticleDto dto);

    public Article detete(Long id);

}
