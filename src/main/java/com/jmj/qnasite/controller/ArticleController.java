package com.jmj.qnasite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleController {

    @GetMapping("/articles/qnaform")
    public String newArticleForm(){
        return "articles/qnaform";
    }
}