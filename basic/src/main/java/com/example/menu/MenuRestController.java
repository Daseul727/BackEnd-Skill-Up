package com.example.menu;

import com.example.menu.application.dto.MenuDto;
import com.example.menu.application.MenuService;
import com.example.utils.api.ApiResponseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/menu")
public class MenuRestController {

    private final MenuService menuService;

    @ResponseBody
    @GetMapping("/list")
    public ResponseEntity getMenuList() {

        List<MenuDto> menuDtoList = menuService.getMenuList();

        return ApiResponseEntity
                .data()
                .put("menu",menuDtoList)
                .ok();
    }

}
