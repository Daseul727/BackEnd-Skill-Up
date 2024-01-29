package com.example.main.application.dto;

import com.example.main.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private String title;
    private String content;
    private String userName;

    public PostDto(Post entity) {
        this.title = entity.getTitle();
        this.content = entity.getContent();
    }
}
