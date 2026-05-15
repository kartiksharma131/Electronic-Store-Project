package com.electronic.store.electronicstore.service.impl;

import com.electronic.store.electronicstore.dtos.CategoryDto;
import com.electronic.store.electronicstore.repository.CategoryRepository;
import com.electronic.store.electronicstore.service.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    CategoryRepository categoryRepository;

    public CategoryServiceImpl(@Autowired CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, String categoryId) {
        return null;
    }

    @Override
    public void deleteCategory(String categoryId) {

    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return List.of();
    }

    @Override
    public CategoryDto getCategoryById(String id) {
        return null;
    }

    @Override
    public CategoryDto getCategoryByTitle(String title) {
        return null;
    }
}

