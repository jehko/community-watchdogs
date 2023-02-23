package com.refactory.communitywatchdogs.article.controller;

import com.refactory.communitywatchdogs.article.entity.Article;
import com.refactory.communitywatchdogs.article.model.ArticleInput;
import com.refactory.communitywatchdogs.article.repository.ArticleRepository;
import com.refactory.communitywatchdogs.article.service.ArticleService;
import com.refactory.communitywatchdogs.common.model.ResponseMessage;
import com.refactory.communitywatchdogs.common.model.ServiceResult;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ArticleController {
    private final ArticleRepository articleRepository;
    private final ArticleService articleService;

    @GetMapping("/api/article")
    public ResponseEntity getAllArticleList() {
        ServiceResult result = articleService.getAllArticleList();

        return ResponseEntity.ok().body(ResponseMessage.success(result.getData()));
    }

    @PostMapping("/api/article")
    public ResponseEntity addArticle(@RequestBody @Valid ArticleInput articleInput, Errors errors) {

        if(errors.hasErrors()) {
            return new ResponseEntity<>(ResponseMessage.fail("입력값이 유효하지 않습니다."), HttpStatus.BAD_REQUEST);
        }

        ServiceResult result = articleService.addArticle(articleInput);

        if(result.isFail()) {
            return ResponseEntity.ok().body(ResponseMessage.fail(result.getMessage()));
        }

        return ResponseEntity.ok().body(ResponseMessage.success(result.getData()));
    }

}
