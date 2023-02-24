package com.refactory.communitywatchdogs.article.controller;

import com.refactory.communitywatchdogs.article.service.ArticleNlpService;
import com.refactory.communitywatchdogs.common.model.ResponseMessage;
import com.refactory.communitywatchdogs.common.model.ServiceResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ArticleNlpController {
    private final ArticleNlpService articleNlpService;

    @GetMapping("/api/article/nlp")
    public ResponseEntity getBuzzCount() {
        ServiceResult result = articleNlpService.getBuzzCount();

        return ResponseEntity.ok().body(ResponseMessage.success(result.getData()));
    }

}