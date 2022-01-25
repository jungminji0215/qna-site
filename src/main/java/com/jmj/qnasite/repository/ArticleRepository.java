package com.jmj.qnasite.repository;

import com.jmj.qnasite.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {

}
