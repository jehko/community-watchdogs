package com.refactory.communitywatchdogs.article.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String category;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private String author;

    @Column
    private String link;

    @Column
    private String articleId;

    @Column
    private LocalDateTime regDate;

    @Column
    private LocalDateTime updateDate;
}
