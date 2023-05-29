package com.bigmoim.module.memberboard.controller;

import com.bigmoim.module.memberboard.entity.MemberBoardEntity;
import com.bigmoim.module.memberboard.service.MemberBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/boards")
public class MemberBoardController {
    private final MemberBoardService memberBoardService;
    @GetMapping("/{moimNum}")
    public String boardList(@PathVariable Integer moimNum, Model model){
        List<MemberBoardEntity> boardList = memberBoardService.boardEntityList(moimNum);

        model.addAttribute("boardList" , boardList);

        return "moimdetail";
    }
}
