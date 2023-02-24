package com.refactory.communitywatchdogs.article.service;

import com.refactory.communitywatchdogs.article.entity.Article;
import com.refactory.communitywatchdogs.article.model.ArticleSentenceResponse;
import com.refactory.communitywatchdogs.article.repository.ArticleRepository;
import com.refactory.communitywatchdogs.common.model.ServiceResult;
import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleNlpService {
    private final ArticleRepository articleRepository;
    private final Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);

    public ServiceResult getBuzzCount() {
        List<Article> articleList = articleRepository.findAll();
        List<String> textArray = new ArrayList<>();

        articleList.stream().forEach(e -> textArray.add(e.getTitle() + " " + e.getContent()));

        KomoranResult komoranResult = komoran.analyze(String.join(" ", textArray));

        return ServiceResult.success(komoranResult.getNouns());
    }

}