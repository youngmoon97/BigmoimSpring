package com.bigmoim.module.zipcode.service;

import com.bigmoim.module.member.repository.MemberRepository;
import com.bigmoim.module.zipcode.repository.ZipcodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ZipcodeService {
    private final ZipcodeRepository zipcodeRepository;
}
