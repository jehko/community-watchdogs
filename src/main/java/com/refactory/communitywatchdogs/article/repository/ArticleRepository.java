package com.refactory.communitywatchdogs.article.repository;

import com.refactory.communitywatchdogs.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByUpdateDateBetween(LocalDateTime start, LocalDateTime end);
    List<Article> findByTitleContainingOrContentContainingAndUpdateDateBetween(String keyword1, String keyword2, LocalDateTime start, LocalDateTime end);

}
