package com.bigmoim.module.classcomment.controller;

import com.bigmoim.module.classcomment.entity.ClassCommentEntity;
import com.bigmoim.module.classcomment.service.ClassCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/classComments")
public class ClassCommentController {
    private ClassCommentService classCommentService;
    @GetMapping
    public String classCommentList(@PathVariable Integer ccNum, Model model){
        List<ClassCommentEntity> classCommentList = classCommentService.classCommentEntityList(ccNum);

        model.addAttribute("classCommentList", classCommentList);

        return "moimdetail";
    }
}
