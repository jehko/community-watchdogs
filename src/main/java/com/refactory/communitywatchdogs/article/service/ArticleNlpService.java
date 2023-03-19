package com.refactory.communitywatchdogs.article.service;

import com.refactory.communitywatchdogs.article.entity.Article;
import com.refactory.communitywatchdogs.article.repository.ArticleRepository;
import com.refactory.communitywatchdogs.common.model.ServiceResult;
import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleNlpService {
    private final ArticleRepository articleRepository;
    private final Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);

    public ServiceResult getNlpList() {
        List<Article> articleList = articleRepository.findAll();
        List<String> textArray = new ArrayList<>();

        articleList.stream().forEach(e -> textArray.add(e.getTitle() + " " + e.getContent()));

        KomoranResult komoranResult = komoran.analyze(String.join(" ", textArray));

        return ServiceResult.success(komoranResult.getNouns());
    }

    public ServiceResult getBuzzCount(String keyword, LocalDate startDate, LocalDate endDate) {

        final LocalDate now = LocalDate.now();
        if (endDate == null) {
            endDate = now;
        }
        if (startDate == null || startDate.isAfter(endDate)) {
            startDate = endDate.minusMonths(1);
        }

        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.atTime(LocalTime.MAX);

        List<Article> articleList = articleRepository
                .findByTitleContainingOrContentContainingAndUpdateDateBetween(keyword, keyword, startDateTime, endDateTime);

        List<String> textArray = new ArrayList<>();

        articleList.stream().forEach(e -> textArray.add(e.getTitle() + " " + e.getContent()));

        KomoranResult komoranResult = komoran.analyze(String.join(" ", textArray));
        Map<String, Long> result = komoranResult.getNouns().stream().collect(Collectors.groupingBy(String::new, Collectors.counting()));

        return ServiceResult.success(result);
    }

}