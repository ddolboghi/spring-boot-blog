package com.siwoli.blog.dto;

import com.siwoli.blog.domain.Article;
import lombok.Getter;

//뷰에 데이터를 전달할 dto
@Getter
public class ArticleListViewResponse {
    private final Long id;
    private final String title;
    private final String content;

    public ArticleListViewResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
