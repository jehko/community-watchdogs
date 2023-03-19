package com.refactory.communitywatchdogs.article.controller;

import com.refactory.communitywatchdogs.article.service.ArticleNlpService;
import com.refactory.communitywatchdogs.common.model.ResponseMessage;
import com.refactory.communitywatchdogs.common.model.ServiceResult;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ArticleNlpController {
    private final ArticleNlpService articleNlpService;

    @GetMapping("/api/article/nlp")
    public ResponseEntity getNlpList() {
        ServiceResult result = articleNlpService.getNlpList();

        return ResponseEntity.ok().body(ResponseMessage.success(result.getData()));
    }

    @GetMapping("/api/article/nlp/{keyword}/count")
    public ResponseEntity getBuzzCount(@PathVariable("keyword") String keyword
            , @RequestParam(value = "startDate", required = false) @DateTimeFormat(pattern = "yyyyMMdd") LocalDate startDate
            , @RequestParam(value = "endDate", required = false) @DateTimeFormat(pattern = "yyyyMMdd") LocalDate endDate) {



        ServiceResult result = articleNlpService.getBuzzCount(keyword, startDate, endDate);

        return ResponseEntity.ok().body(ResponseMessage.success(result.getData()));
    }

}