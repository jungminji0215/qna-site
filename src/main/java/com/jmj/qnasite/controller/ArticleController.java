package com.jmj.qnasite.controller;

import com.jmj.qnasite.dto.ArticleDto;
import com.jmj.qnasite.dto.CommentDto;
import com.jmj.qnasite.domain.article.Article;
import com.jmj.qnasite.domain.article.ArticleRepository;
import com.jmj.qnasite.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class ArticleController {

    private final CommentService commentService;

    private final ArticleRepository articleRepository;

    // 메인
    @GetMapping("/")
    public String index(Model model){
        log.info("메인");
        List<Article> articleEntityList = articleRepository.findAll();
        model.addAttribute("articleList", articleEntityList);
        return "/articles/index";
    }

    // 메인
    @GetMapping("/articles")
    public String index2(Model model){
        log.info("메인");
        List<Article> articleEntityList = articleRepository.findAll();
        model.addAttribute("articleList", articleEntityList);
        return "articles/index";
    }

    // 새 글 등록 페이지
    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    // 글 생성
    @PostMapping("/articles/create")
    public String createArticle(ArticleDto form){
        Article article = form.toEntity();
        Article saved = articleRepository.save(article);
        return "redirect:/articles/" + saved.getId();
    }

    // 게시글 상세
    @GetMapping("/articles/{id}")
    public String findById(@PathVariable Long id, Model model){
        Article articleEntity = articleRepository.findById(id).orElse(null);
        model.addAttribute("article", articleEntity);

        List<CommentDto> commentDtos = commentService.comments(id);
        model.addAttribute("commentDtos", commentDtos);

        return "articles/show";
    }



    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        Article articleEntity = articleRepository.findById(id).orElse(null);
        model.addAttribute("article", articleEntity);
        return "articles/edit";
    }

    @PostMapping("/articles/update")
    public String update(ArticleDto form){
        log.info(form.toString());

        // DTO를 Entity로 변환
        Article articleEntity = form.toEntity();

        log.info(articleEntity.toString());
        Article target = articleRepository.findById(articleEntity.getId()).orElse(null);

        if(target != null){
            articleRepository.save(articleEntity);
        }

       return "redirect:/articles/" + articleEntity.getId();
    }

    // 게시글 삭제
    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rt){
        log.info("삭제");

        Article target = articleRepository.findById(id).orElse(null);
        log.info(target.toString());

        if(target != null){
            articleRepository.delete(target);
            rt.addFlashAttribute("msg", "삭제가 왼료되었습니다!");
        }

        return "redirect:/articles";
    }
}