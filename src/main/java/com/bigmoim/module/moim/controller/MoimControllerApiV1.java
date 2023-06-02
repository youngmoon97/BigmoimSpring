package com.bigmoim.module.moim.controller;

import com.bigmoim.config.security.CustomUserDetails;
import com.bigmoim.module.moim.dto.MoimDTO;
import com.bigmoim.module.moim.service.MoimServiceApiV1;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/moim")
public class MoimControllerApiV1 {
    private final MoimServiceApiV1 moimServiceApiV1;

    @PostMapping("/makemoim")
    public HttpEntity<?> moimInsert(@AuthenticationPrincipal CustomUserDetails customUserDetails,
            @Validated @RequestBody MoimDTO.ReqMakeMoim reqMakeMoim) {
        return moimServiceApiV1.moimInsert(customUserDetails, reqMakeMoim);
    }
}
