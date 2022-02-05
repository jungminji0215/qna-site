INSERT INTO article(id, title, content) VALUES (1, '제목1', '내용1');
INSERT INTO article(id, title, content) VALUES (2, '제목2', '내용2');
INSERT INTO article(id, title, content) VALUES (3, '제목3', '내용3');
INSERT INTO article(id, title, content) VALUES (4, '좋아하는 영화는?', '댓글좀...');
INSERT INTO article(id, title, content) VALUES (5, '자바 VS 파이썬', '댓글 달아주시면 안 돼요?');

INSERT INTO comment(id, article_id, content) VALUES (1, 4, '해리포터');
INSERT INTO comment(id, article_id, content) VALUES (2, 4, '토이스토리');
INSERT INTO comment(id, article_id, content) VALUES (3, 5, '자바가 좋아요');
INSERT INTO comment(id, article_id, content) VALUES (4, 5, '파이썬도 좋아요');

