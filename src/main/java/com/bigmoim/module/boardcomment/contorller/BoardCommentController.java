package com.bigmoim.module.boardcomment.contorller;

import com.bigmoim.module.boardcomment.entity.BoardCommentEntity;
import com.bigmoim.module.boardcomment.service.BoardCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/boardComments")
public class BoardCommentController {
    private final BoardCommentService boardCommentService;
    @GetMapping("/{mbNum}")
    public String boardCommentList(@PathVariable Integer mbNum, Model model){
        List<BoardCommentEntity> boardCommentList = boardCommentService.boardCommentEntityList(mbNum);

        model.addAttribute("boardCommentList", boardCommentList);

        return "moimdetail";
    }
}
