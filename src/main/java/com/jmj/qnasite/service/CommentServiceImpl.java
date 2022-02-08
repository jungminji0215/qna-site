package com.jmj.qnasite.service;

import com.jmj.qnasite.dto.ArticleDto;
import com.jmj.qnasite.dto.CommentDto;
import com.jmj.qnasite.entity.Article;
import com.jmj.qnasite.entity.Comment;
import com.jmj.qnasite.repository.ArticleRepository;
import com.jmj.qnasite.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final ArticleRepository articleRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, ArticleRepository articleRepository) {
        this.commentRepository = commentRepository;
        this.articleRepository = articleRepository;
    }

    // 댓글 조회
    @Override
    public List<CommentDto> comments(Long articleId) {
//        // 댓글 조회
//        List<Comment> comments = commentRepository.findByArticleId(articleId);
//
//        // 엔티티를 dto로 변환
//        List<CommentDto> dtos = new ArrayList<CommentDto>();
//
//        for(int i = 0; i < comments.size(); i++){
//            Comment comment = comments.get(i);
//            CommentDto dto = CommentDto.createCommentDto(comment);
//            dtos.add(dto);
//        }

        return commentRepository.findByArticleId(articleId)
                .stream()
                .map(comment -> CommentDto.createCommentDto(comment))
                .collect(Collectors.toList());
    }

    // 댓글 등록
    @Transactional // DB에 변경이 일어나기 때문에 트랜잭션 처리
    @Override
    public CommentDto create(Long articleId, CommentDto dto) {
        // 게시글 조회 및 예외 발생
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("댓글 등록 실패, 해당 게시글이 존재하지 않습니다.")); // 예외 발생 시, 아래 실행 안 됨

        // 댓글 엔티티 생성
        Comment comment = Comment.createComment(dto, article);

        // 댓글 엔티티를 DB로 저장
        Comment created = commentRepository.save(comment);

        // DTO로 변경하여 반환
        return CommentDto.createCommentDto(created);
    }

    @Transactional
    @Override
    public CommentDto update(Long id, CommentDto dto) {
        // 댓글 조회
        Comment target = commentRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("댓글 수정 실패, 해당 댓글이 없습니다."));

        // 조회한 댓글 수정
        target.patch(dto);

        // 수정한 댓글 DB에 저장
        Comment updatedComment = commentRepository.save(target);

        // Entity를 DTO 로 변환하여 반환
        return CommentDto.createCommentDto(updatedComment);
    }

    @Transactional
    @Override
    public CommentDto delete(Long id) {
        Comment target = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("댓글 삭제 실패, 해당 댓글이 없습니다."));

        commentRepository.delete(target);
        return CommentDto.createCommentDto(target);
    }
}