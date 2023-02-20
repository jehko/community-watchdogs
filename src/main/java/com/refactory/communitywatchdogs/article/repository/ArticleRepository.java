package com.refactory.communitywatchdogs.article.repository;

import com.refactory.communitywatchdogs.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {}
