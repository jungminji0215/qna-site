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

//    public static Comment createComment(CommentDto dto, Article article) {
//    }
}
