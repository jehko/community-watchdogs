package com.refactory.communitywatchdogs.article.controller;

import com.refactory.communitywatchdogs.article.entity.Article;
import com.refactory.communitywatchdogs.article.model.ArticleInput;
import com.refactory.communitywatchdogs.article.repository.ArticleRepository;
import com.refactory.communitywatchdogs.common.model.ResponseMessage;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ArticleController {
    private final ArticleRepository articleRepository;

    @GetMapping("/api/article")
    public ResponseEntity getAllArticle() {
        List<Article> articleList = articleRepository.findAll();

        return ResponseEntity.ok().body(ResponseMessage.success(articleList));
    }

    @PostMapping("/api/article")
    public String addArticle(@RequestBody @Valid ArticleInput articleInput, Errors errors) {

        articleRepository.save(Article.builder()
                .category(articleInput.getCategory())
                .title(articleInput.getTitle())
                .content(articleInput.getContent())
                .author(articleInput.getAuthor())
                .link(articleInput.getLink())
                .regDate(LocalDateTime.now())
                .build());

        return "success";
    }

}
