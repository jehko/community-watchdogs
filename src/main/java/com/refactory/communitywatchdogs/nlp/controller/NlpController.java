package com.refactory.communitywatchdogs.nlp.controller;

import com.refactory.communitywatchdogs.article.entity.Article;
import com.refactory.communitywatchdogs.nlp.service.NlpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class NlpController {

    private final NlpService nlpService;

    @GetMapping("/api/nlp")
    public List<String> getBuzzCount() {
        return nlpService.getBuzzCount();
    }
}
