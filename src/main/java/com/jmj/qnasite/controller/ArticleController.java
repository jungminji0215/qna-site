package com.jmj.qnasite.controller;

import com.jmj.qnasite.dto.ArticleForm;
import com.jmj.qnasite.entity.Article;
import com.jmj.qnasite.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
@Slf4j
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        log.info(form.toString());

        Article article = form.toEntity();
        log.info(article.toString());

        Article saved = articleRepository.save(article);
        log.info(saved.toString());

        return "";
    }

    @GetMapping("articles/{id}")
    public String findById(@PathVariable Long id, Model model){
        log.info("id = " + id);

        // 아이디로 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);

        // 가져온 데이터 모델에 등록
        model.addAttribute("article", articleEntity);

        // 보여줄 페이지 설정
        return "articles/show";
    }
}