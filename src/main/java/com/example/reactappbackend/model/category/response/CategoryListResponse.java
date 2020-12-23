package com.example.reactappbackend.model.category.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoryListResponse {
    private List<Category> categoryList;

    @Data
    @Builder
    public static class Category {
        private Integer categoryId;
        private String categoryName;
    }
}
