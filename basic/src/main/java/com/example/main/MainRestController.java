package com.example.main;

import com.example.main.application.MainService;
import com.example.main.domain.PostDto;
import com.example.utils.api.ApiResponseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/main")
public class MainRestController {

    private final MainService mainService;

    /**
     * @return ResponseEntity
     */
    @ResponseBody
    @GetMapping("")
    public ResponseEntity index() {
        return ApiResponseEntity
                .builder()
                .ok();
    }

    /**
     * @param status parameter
     * @return new ResponseEntity
     */
    @ResponseBody
    @GetMapping("/index-new")
    public ResponseEntity indexNew(HttpStatus status) {
        return new ApiResponseEntity(status);
    }


    @ResponseBody
    @GetMapping("/post/{postId}")
    public ResponseEntity getMainCategoryChild(@PathVariable long postId) {

        PostDto postDto = mainService.getPost(postId);

        return ApiResponseEntity.data()
                .put("post",postDto)
                .ok();
    }

}
