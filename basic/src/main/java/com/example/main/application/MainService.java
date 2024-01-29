package com.example.main.application;

import com.example.main.domain.PostDto;

import java.util.List;

public interface MainService {

    /**
     * post 목록 조회
     * @return post dto list
     */
    public List<PostDto> getPostList();

    /**
     * post 상세 조회
     * @return
     */
    public PostDto getPost(long id);
}
