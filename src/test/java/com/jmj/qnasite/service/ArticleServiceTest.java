package com.jmj.qnasite.service;

import com.jmj.qnasite.entity.Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleServiceTest {

    @Autowired
    ArticleService articleService;

    @Test
    void 전체조회() {
        // given
        Article memberA = new Article(1L, "제목1", "정민지", "내용1");
        Article memberB = new Article(2L, "제목2", "정민지", "내용2");
        Article memberC = new Article(3L, "제목3", "정민지", "내용3");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(memberA, memberB, memberC));

        // when
        List<Article> articles = articleService.index();

        // then
        assertEquals(expected.toString(), articles.toString());
    }

    @Test
    @DisplayName("존재하는 id 테스트")
    void 존재하는_아이디() {
        // given
        Article memberA = new Article(1L, "제목1", "정민지", "내용1");

        // when
        Article show = articleService.show(memberA.getId());

        // then
        assertEquals(memberA.getId(), show.getId());
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void detete() {
    }
}