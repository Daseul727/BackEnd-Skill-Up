package com.example.main.structure;

import com.example.main.application.MainService;
import com.example.main.domain.PostDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainServiceImpl implements MainService {
    @Override
    public List<PostDto> getPost() {

        List<PostDto> result = new ArrayList<>();
        result.add(new PostDto());

        return result;
    }
}
