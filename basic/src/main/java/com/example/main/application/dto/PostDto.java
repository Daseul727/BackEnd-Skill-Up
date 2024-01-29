package com.example.main.application.dto;

import com.example.main.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private String title;
    private String content;
    private String userName;

    private MultipartFile thumbnailFile;

    public PostDto(Post entity) {
        this.title = entity.getTitle();
        this.content = entity.getContent();
    }

    public Post toEntity(PostDto dto) {
        Post entity = new Post();
        entity.setContent(dto.getContent());
        entity.setTitle(dto.getTitle());
        return entity;
    }
}
