package com.BlogApp.Blogz.services.impl;

import com.BlogApp.Blogz.entities.Category;
import com.BlogApp.Blogz.entities.User;
import com.BlogApp.Blogz.exceptions.ResourceNotFoundException;
import com.BlogApp.Blogz.payloads.CategoryDto;
import com.BlogApp.Blogz.repositories.CategoryRepo;
import com.BlogApp.Blogz.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
       Category cat = this.modelMapper.map(categoryDto, Category.class);
       Category added = this.categoryRepo.save(cat);
       return this.modelMapper.map(added, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
        category.setCategoryTitle(categoryDto.getCategoryTitle());
        category.setCategoryDescription(categoryDto.getCategoryDescription());

        Category updateCategory = this.categoryRepo.save(category);
        return this.modelMapper.map(updateCategory, CategoryDto.class);

    }

    @Override
    public void deleteCategory(Integer CategoryId) {
        Category category = this.categoryRepo.findById(CategoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "id", CategoryId));
        this.categoryRepo.delete(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categoryList = this.categoryRepo.findAll();
       List<CategoryDto> categories =  categoryList.stream().map((cat) -> this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
        return categories;
    }

    @Override
    public CategoryDto getSingleCategory(Integer categoryId) {
        Category getOne = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "id",categoryId));
        return this.modelMapper.map(getOne,CategoryDto.class);
    }
}
