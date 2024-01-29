package com.example.menu.structure;

import com.example.menu.application.MenuMapper;
import com.example.menu.application.dto.MenuDto;
import com.example.menu.application.MenuService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MenuServiceImpl implements MenuService {

    private final MenuMapper menuMapper;

    @Override
    public List<MenuDto> getMenuList() {
        //mybatis 요청
        return menuMapper.getMenuList();
    }
}
