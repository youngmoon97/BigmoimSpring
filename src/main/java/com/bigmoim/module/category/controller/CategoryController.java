package com.bigmoim.module.category.controller;

import com.bigmoim.module.category.dto.CategoryDTO;
import com.bigmoim.module.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/categoryList")
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping
    public String getCategoryPage(Model model){
        CategoryDTO.ResBasic resDto = categoryService.getCategoryList();
//        System.out.println(categoryList);
        model.addAttribute("resDto", resDto);
        return "/main/categoryList";
    }

}
