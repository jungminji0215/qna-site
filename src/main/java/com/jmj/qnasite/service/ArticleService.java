package com.jmj.qnasite.service;

import com.jmj.qnasite.dto.ArticleDto;
import com.jmj.qnasite.domain.article.Article;

import java.util.List;

public interface ArticleService {

    // 메인
    List<Article> index();

    // 글 상세보기
    Article show(Long id);

    // 새 글 작성
    Article create(ArticleDto dto);

    // 수정
    Article update(Long id, ArticleDto dto);

    // 삭제
    Article detete(Long id);

}
