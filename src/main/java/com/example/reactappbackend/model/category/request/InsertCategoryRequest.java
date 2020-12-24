package com.example.reactappbackend.model.category.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InsertCategoryRequest {
    private String categoryName;
}
