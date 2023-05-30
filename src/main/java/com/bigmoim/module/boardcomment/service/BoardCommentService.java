package com.bigmoim.module.boardcomment.service;

import com.bigmoim.module.boardcomment.entity.BoardCommentEntity;
import com.bigmoim.module.boardcomment.repository.BoardCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardCommentService {
    private  final BoardCommentRepository boardCommentRepository;

    public List<BoardCommentEntity> boardCommentEntityList(Integer mbNum){
        return boardCommentRepository.bcList(mbNum);
    }
}
