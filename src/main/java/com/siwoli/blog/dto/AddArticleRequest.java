package com.siwoli.blog.dto;

import com.siwoli.blog.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor//모든 필드 값을 파라미터로 받는 생성자
@Getter
public class AddArticleRequest {
    private String title;
    private String content;

    public Article toEntity() {
        //요청 받은 Ariticle 데이터를 가진 객체 생성 
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}
