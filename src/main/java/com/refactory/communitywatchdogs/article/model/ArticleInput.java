package com.refactory.communitywatchdogs.article.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ArticleInput {
    private String category;


    @NotBlank(message = "title field is required")
    private String title;

    private String content;

    private String author;

    private String link;

    private String articleId;

    private LocalDateTime regDate;

    private LocalDateTime updateDate;
}
