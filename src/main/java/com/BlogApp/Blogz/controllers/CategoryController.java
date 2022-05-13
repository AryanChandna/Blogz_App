package com.BlogApp.Blogz.controllers;

import com.BlogApp.Blogz.payloads.ApiResponse;
import com.BlogApp.Blogz.payloads.CategoryDto;
import com.BlogApp.Blogz.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto category) {

        CategoryDto createdCategory = this.categoryService.createCategory(category);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @PutMapping("/{CategoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto category, @PathVariable Integer CategoryId) {

        CategoryDto updatedCategory = this.categoryService.updateCategory(category, CategoryId);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    @DeleteMapping("/{CategoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer CategoryId) {

        this.categoryService.deleteCategory(CategoryId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Category is deleted", true), HttpStatus.OK);

    }

    @GetMapping("/{CategoryId}")
    public ResponseEntity<CategoryDto> getSingleCategory(@PathVariable Integer CategoryId) {

        CategoryDto categoryDto = this.categoryService.getSingleCategory(CategoryId);
        return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        List<CategoryDto> categories = this.categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }
}
