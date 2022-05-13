package com.BlogApp.Blogz.services;

import com.BlogApp.Blogz.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    void deleteCategory(Integer CategoryId);

    List<CategoryDto> getAllCategories();

    CategoryDto getSingleCategory(Integer Id);
}
