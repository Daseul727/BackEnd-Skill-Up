package com.example.main;

import com.example.utils.ApiResponseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/main")
public class MainController {
    @ResponseBody
    @GetMapping("")
    public ResponseEntity index() {
        String result = "SUCCESS!!";

        return ApiResponseEntity
                .data()
                .put("result", result)
                .ok();
    }
}
