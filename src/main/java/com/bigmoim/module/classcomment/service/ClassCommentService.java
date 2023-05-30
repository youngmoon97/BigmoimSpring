package com.bigmoim.module.classcomment.service;

import com.bigmoim.module.classcomment.entity.ClassCommentEntity;
import com.bigmoim.module.classcomment.repository.ClassCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClassCommentService {
    private final ClassCommentRepository classCommentRepository;

    // 클래스 모임 기준으로 댓글 리스트 출력
    public List<ClassCommentEntity> classCommentEntityList(Integer moimNum){
        return classCommentRepository.ccList(moimNum);
    }
}
