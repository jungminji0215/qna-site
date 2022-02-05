package com.jmj.qnasite.service;

import com.jmj.qnasite.dto.CommentDto;

import java.util.List;

public interface CommentService {

    // 댓글 조회
    List<CommentDto> comments(Long articleId);

    // 댓글 등록
    CommentDto create(Long articleId, CommentDto dto);
}
