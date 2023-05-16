package com.bigmoim.module.moim.service;

import com.bigmoim.module.member.repository.MemberRepository;
import com.bigmoim.module.moim.repository.MoimRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MoimService {
    private final MoimRepository moimRepository;
}
