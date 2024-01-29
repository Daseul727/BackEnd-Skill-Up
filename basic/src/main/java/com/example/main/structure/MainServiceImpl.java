package com.example.main.structure;

import com.example.file.application.FileService;
import com.example.main.application.MainService;
import com.example.main.domain.Post;
import com.example.main.application.dto.PostDto;
import com.example.main.domain.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MainServiceImpl implements MainService {

    private final PostRepository postRepository;

    private final FileService fileService;

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

    @Override
    public void addPost(PostDto postDto) throws Exception {

        //1. jpa entity save
        Post entity = postRepository.save(postDto.toEntity(postDto));

        if (!ObjectUtils.isEmpty(postDto.getThumbnailFile())) {
            String path = "/post/" + entity.getId() + "/thumbnail";
            String savedPath = fileService.saveThumbnailImage(path, postDto.getThumbnailFile());

            //2. entity update 더티체킹
            entity.setImagePath(savedPath);
        }

    }


}
