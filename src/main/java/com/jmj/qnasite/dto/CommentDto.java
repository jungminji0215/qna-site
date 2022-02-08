package com.jmj.qnasite.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jmj.qnasite.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class CommentDto {

    private Long id;

    @JsonProperty("article_id")
    private Long articleId;

    private String content;

    // 엔티티를 DTO로 변환
    public static CommentDto createCommentDto(Comment comment){
        return new CommentDto(
                comment.getId(),
                comment.getArticle().getId(),
                comment.getContent()
        );
    }
}
