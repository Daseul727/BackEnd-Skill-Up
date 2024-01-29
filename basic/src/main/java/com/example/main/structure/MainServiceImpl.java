package com.example.main.structure;

import com.example.main.application.MainService;
import com.example.main.domain.Post;
import com.example.main.application.dto.PostDto;
import com.example.main.domain.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MainServiceImpl implements MainService {

    private final PostRepository postRepository;

    @Override
    public List<PostDto> getPostList() {

        List<PostDto> result = new ArrayList<>();
        result.add(new PostDto());

        return result;
    }

    @Override
    public PostDto getPost(long id) {
        Post entity = postRepository.findById(id);
        return new PostDto(entity);
    }


}
