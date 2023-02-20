package com.refactory.communitywatchdogs.article.controller;

import com.refactory.communitywatchdogs.article.entity.Article;
import com.refactory.communitywatchdogs.article.model.ArticleInput;
import com.refactory.communitywatchdogs.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
public class ArticleController {
    private final ArticleRepository articleRepository;

    @GetMapping("/api/article")
    public String getArticle() {
        return "article 테스트";
    }

    @PostMapping("/api/article")
    public String addArticle(@RequestBody ArticleInput articleInput, Errors errors) {

        articleRepository.save(Article.builder()
                .title(articleInput.getTitle())
                .content(articleInput.getContent())
                .author(articleInput.getAuthor())
                .link(articleInput.getLink())
                .regDate(LocalDateTime.now())
                .build());

        return "success";
    }

}
