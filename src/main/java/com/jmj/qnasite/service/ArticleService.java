package com.jmj.qnasite.service;

import com.jmj.qnasite.dto.ArticleDto;
import com.jmj.qnasite.entity.Article;
import com.jmj.qnasite.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> index() {
        return articleRepository.findAll();
    }

    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(ArticleDto dto) {
        Article article = dto.toEntity();

        if(article.getId() != null){
            return null;
        }
        return articleRepository.save(article);
    }

    public Article update(Long id, ArticleDto dto) {
        Article article = dto.toEntity();
        Article target = articleRepository.findById(id).orElse(null);

        if(target == null || id != article.getId()){
            log.info("잘못된 요청");
            return null;
        }

        target.patch(article);
        Article updated = articleRepository.save(target);

        return updated;
    }

    public Article detete(Long id) {
        Article target = articleRepository.findById(id).orElse(null);

        if(target == null){
            return null;
        }

        articleRepository.delete(target);
        return target;
    }
}