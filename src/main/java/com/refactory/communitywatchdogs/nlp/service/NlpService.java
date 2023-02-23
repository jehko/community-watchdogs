package com.refactory.communitywatchdogs.nlp.service;

import com.refactory.communitywatchdogs.article.repository.ArticleRepository;
import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NlpService {
    private final ArticleRepository articleRepository;
    private final Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);

    public List<String> getBuzzCount() {
        KomoranResult resultList = komoran.analyze("안녕하세요. 반갑습니다. 안녕히 계세요. 안녕하세요. 안녕?");

        return resultList.getNouns();
    }

}
