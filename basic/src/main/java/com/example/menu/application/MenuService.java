package com.example.menu.application;

import com.example.menu.application.dto.MenuDto;

import java.util.List;

public interface MenuService {
    /**
     * 메뉴 목록 조회
     * @return
     */
    public List<MenuDto> getMenuList();
}
