package com.example.reactappbackend.mapper;

import com.example.reactappbackend.model.dto.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryMapper {

    List<Category> categoryList();

    void insertCategory(String categoryName);

    void deleteCategory(Integer categoryId);
}
