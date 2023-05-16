package com.bigmoim.module.memberboard.service;

import com.bigmoim.module.memberboard.repository.MemberBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberBoardService {
    private final MemberBoardRepository memberBoardRepository;
}
