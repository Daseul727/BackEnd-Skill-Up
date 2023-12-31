package com.example.main;

import com.example.utils.api.ApiResponseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/main")
public class MainRestController {

    /**
     * return ResponseEntity
     * @return
     */
    @ResponseBody
    @GetMapping("")
    public ResponseEntity index() {
        return ApiResponseEntity
                .builder()
                .ok();
    }

    /**
     * return new ResponseEntity
     * @param status
     * @return
     */
    @ResponseBody
    @GetMapping("/index-new")
    public ResponseEntity indexNew(HttpStatus status) {
        return new ApiResponseEntity(status);
    }

}
