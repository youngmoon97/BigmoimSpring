package com.bigmoim.module.category.repository;

import com.bigmoim.module.boardcomment.entity.BoardCommentEntity;
import com.bigmoim.module.category.entity.CategoryEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CategoryRepository {
     List<CategoryEntity> categoryList();
     CategoryEntity categoryImg(int num);
     CategoryEntity categoryName(int num);
}
