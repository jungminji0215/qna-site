package com.jmj.qnasite.api;

import com.jmj.qnasite.dto.ArticleDto;
import com.jmj.qnasite.entity.Article;
import com.jmj.qnasite.repository.ArticleRepository;
import com.jmj.qnasite.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

// 반환 타입 ResponseEntity로 변경할 것

@Slf4j
@RestController // 데이터를 JSON 형태로 반환한다.
public class ArticleApiController {

    // refactoring - 생성자 주입 방법 수정할 것
    @Autowired
    private ArticleService articleService;

    // 게시글 전체 조회
    @GetMapping("/api/articles")
    public List<Article> index(){
        return articleService.index();
    }

    // 게시글 한 개 조회
    @GetMapping("/api/articles/{id}")
    public Article show(@PathVariable Long id){
        return articleService.show(id);
    }

    // 게시글 생성
    // JSON으로 데이터 요청하니까 @RequestBody을 사용해서 데이터 받아주기
    @PostMapping("/api/articles")
    public ResponseEntity<Article> create(@RequestBody ArticleDto dto){
        Article created = articleService.create(dto);

        // 삼항 연산자
        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    // 게시글 수정
    // URI에 있는 id를 받아야하기 때문에 @PathVariable을 사용하기
    @PatchMapping("/api/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleDto dto){
       Article updated = articleService.update(id, dto);
       return (updated != null) ?
               ResponseEntity.status(HttpStatus.OK).body(updated) :
               ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }

    // 게시글 삭제
    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id){
        Article deleted = articleService.detete(id);
        return (deleted != null) ?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
