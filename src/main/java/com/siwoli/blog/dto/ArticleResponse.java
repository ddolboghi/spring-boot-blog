package com.siwoli.blog.dto;

import com.siwoli.blog.domain.Article;
import lombok.Getter;
//응답을 위한 dto
@Getter
public class ArticleResponse {
    private final String title;
    private final String content;

    public ArticleResponse(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
