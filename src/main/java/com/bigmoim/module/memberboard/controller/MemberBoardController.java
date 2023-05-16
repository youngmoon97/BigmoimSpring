package com.bigmoim.module.memberboard.controller;

import com.bigmoim.module.memberboard.service.MemberBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class MemberBoardController {
    private final MemberBoardService memberBoardService;
}
