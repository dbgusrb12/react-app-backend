package com.example.reactappbackend.service;

import com.example.reactappbackend.mapper.CategoryMapper;
import com.example.reactappbackend.model.category.response.CategoryListResponse;
import com.example.reactappbackend.model.dto.Category;
import com.example.reactappbackend.utils.exception.Error;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.reactappbackend.utils.exception.ErrorCode.*;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryMapper categoryMapper;

    public CategoryListResponse categoryList() {
        List<Category> categoryList = categoryMapper.categoryList();

        return CategoryListResponse.builder()
                .categoryList(
                        categoryList.stream().map(
                                category -> CategoryListResponse.Category.builder()
                                        .categoryId(category.getCategoryId())
                                        .categoryName(category.getCategoryName())
                                        .build())
                        .collect(Collectors.toList()))
                .build();
    }

    public void insertCategory(String categoryName) {
        if(!StringUtils.hasText(categoryName)) {
            throw Error.of(MissingParameter, "categoryName is empty");
        }
        try {
            categoryMapper.insertCategory(categoryName);
        } catch (Exception e) {
            throw Error.of(JdbcError, e.getMessage());
        }
    }

    public void deleteCategory(Integer categoryId) {
        try{
            categoryMapper.deleteCategory(categoryId);
        } catch (Exception e) {
            throw Error.of(JdbcError, e.getMessage());
        }
    }
}
