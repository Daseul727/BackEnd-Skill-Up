package com.example.main;

import com.example.main.application.MainService;
import com.example.main.application.dto.PostDto;
import com.example.utils.api.ApiResponseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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


    /**
     * use jpa example
     * @param postId
     * @return
     */
    @ResponseBody
    @GetMapping("/post/{postId}")
    public ResponseEntity getPostDetail(@PathVariable long postId) {

        PostDto postDto = mainService.getPost(postId);

        return ApiResponseEntity.data()
                .put("post",postDto)
                .ok();
    }

    @ResponseBody
    @PostMapping("/post/add")
    public ResponseEntity saveDayPost(@ModelAttribute PostDto dto,
                                      @RequestParam(value = "thumbnailFile",required = false) MultipartFile thumbnailFile) {

        if (!ObjectUtils.isEmpty(thumbnailFile)) {
            dto.setThumbnailFile(thumbnailFile);
        }

        try {
            mainService.addPost(dto);
        } catch (Exception e) {
            return ApiResponseEntity.data().error();
        }

        return ApiResponseEntity.data()
                .put("success", true)
                .ok();
    }


}
