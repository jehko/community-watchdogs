package com.refactory.communitywatchdogs.article.service;

import com.refactory.communitywatchdogs.article.entity.Article;
import com.refactory.communitywatchdogs.article.model.ArticleInput;
import com.refactory.communitywatchdogs.article.repository.ArticleRepository;
import com.refactory.communitywatchdogs.common.model.ServiceResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ServiceResult getAllArticleList() {
        List<Article> articleList = articleRepository.findAll();

        return ServiceResult.success(articleList);
    }


    public ServiceResult addArticle(ArticleInput articleInput) {

        Article article = articleRepository.save(Article.builder()
                        .category(articleInput.getCategory())
                        .title(articleInput.getTitle())
                        .content(articleInput.getContent())
                        .author(articleInput.getAuthor())
                        .link(articleInput.getLink())
                        .regDate(LocalDateTime.now())
                        .build());

        return ServiceResult.success(article);
    }

}
