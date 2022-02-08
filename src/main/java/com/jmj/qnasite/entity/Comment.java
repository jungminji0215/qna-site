package com.jmj.qnasite.entity;

import com.jmj.qnasite.dto.CommentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 댓글의 부모 게시글
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    private String content;

    public static Comment createComment(CommentDto dto, Article article) {

        // 댓글의 id가 있을 경우
        if(dto.getId() != null){
            throw new IllegalArgumentException("댓글 등록 실패, 댓글의 id가 없어야 합니다.");
        }

        // id가 잘못되었을 때
        if (dto.getArticleId() != article.getId()) {
            throw new IllegalArgumentException("댓글 등록 실패, 게시글의 id가 잘못되었습니다.");
       }

        return new Comment(
                dto.getId(),
                article,
                dto.getContent()
        );
    }

    public void patch(CommentDto dto) {

        if(this.id != dto.getId()){
            throw new IllegalArgumentException("댓글 수정 실패, id가 잘못되었습니다.");
        }

        if(dto.getContent() != null){
            this.content = dto.getContent();
        }
    }
}
