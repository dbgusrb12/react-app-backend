package com.example.reactappbackend.controller;

import com.example.reactappbackend.model.category.request.InsertCategoryRequest;
import com.example.reactappbackend.model.category.response.CategoryListResponse;
import com.example.reactappbackend.service.CategoryService;
import com.example.reactappbackend.utils.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public Response<CategoryListResponse> categoryList() {
        CategoryListResponse categoryListResponse = categoryService.categoryList();
        return new Response<>(categoryListResponse);
    }

    @PostMapping
    public Response insertCategory(@RequestBody InsertCategoryRequest insertCategoryRequest) {
        categoryService.insertCategory(insertCategoryRequest);
        return Response.ok();
    }

    @DeleteMapping(value = "/{categoryId}")
    public Response deleteCategory(@PathVariable Integer categoryId) {
        categoryService.deleteCategory(categoryId);
        return Response.ok();
    }
}
