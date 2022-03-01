package com.jmj.qnasite.api;

import com.jmj.qnasite.dto.ArticleDto;
import com.jmj.qnasite.domain.article.Article;
import com.jmj.qnasite.service.ArticleServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 반환 타입 ResponseEntity로 변경할 것

@Slf4j
@RequiredArgsConstructor
@RestController // 데이터를 JSON 형태로 반환한다.
public class ArticleApiController {

    private final ArticleServiceImpl articleServiceImpl;

    // 게시글 전체 조회
    @GetMapping("/api/articles")
    public List<Article> index(){
        return articleServiceImpl.index();
    }

    // 게시글 한 개 조회
    @GetMapping("/api/articles/{id}")
    public Article show(@PathVariable Long id){
        return articleServiceImpl.show(id);
    }

    // 게시글 생성
    // JSON으로 데이터 요청하니까 @RequestBody을 사용해서 데이터 받아주기
    @PostMapping("/api/articles")
    public ResponseEntity<Article> create(@RequestBody ArticleDto dto){
        Article created = articleServiceImpl.create(dto);

        // 삼항 연산자
        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    // 게시글 수정
    // URI에 있는 id를 받아야하기 때문에 @PathVariable을 사용하기
    @PatchMapping("/api/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleDto dto){
       Article updated = articleServiceImpl.update(id, dto);
       return (updated != null) ?
               ResponseEntity.status(HttpStatus.OK).body(updated) :
               ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }

    // 게시글 삭제
    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id){
        Article deleted = articleServiceImpl.detete(id);
        return (deleted != null) ?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
