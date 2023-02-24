package com.refactory.communitywatchdogs.article.model;

import com.refactory.communitywatchdogs.article.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleSentenceResponse {
    private String title;
    private String content;

    public static ArticleSentenceResponse of(Article article) {
        return ArticleSentenceResponse.builder()
                .title(article.getTitle())
                .content(article.getContent())
                .build();
    }
}
