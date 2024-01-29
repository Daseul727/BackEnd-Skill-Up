package com.example.menu.application;

import com.example.menu.application.dto.MenuDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    /**
     * 메뉴 목록 조회
     * @return
     */
    List<MenuDto> getMenuList();

}
