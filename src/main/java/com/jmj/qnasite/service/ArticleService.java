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

// refactoring - serviceimpl 만들기

@Slf4j
@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    // 게시글 전체 조회
    public List<Article> index() {
        return articleRepository.findAll();
    }

    // 게시글 한 개 조회
    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    // 게시글 생성
    public Article create(ArticleDto dto) {
        Article article = dto.toEntity();

        if(article.getId() != null){
            return null;
        }
        return articleRepository.save(article);
    }

    // 게시글 수정
    public Article update(Long id, ArticleDto dto) {

        // 수정용 엔티티 생성
        Article article = dto.toEntity();

        // 대상 엔티티 조회
        Article target = articleRepository.findById(id).orElse(null);

        // 잘못된 요청(대상이 없거나, URL로 온 id랑 dto로 받아온 id가 다른 경우
        if(target == null || id != article.getId()){
            log.info("잘못된 요청");
            return null;
        }

        // 새롭게 변경한 것만.. save 하려고
        target.patch(article);

        // 정상
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