package com.electronic.store.electronicstore.service.interfaces;

import com.electronic.store.electronicstore.dtos.CategoryDto;

import java.util.List;

public interface CategoryService {

    //create category
    CategoryDto createCategory(CategoryDto categoryDto);

    //update category
    CategoryDto updateCategory(CategoryDto categoryDto, String categoryId);

    //delete category
    void deleteCategory(String categoryId);

    // get all categories
    List<CategoryDto> getAllCategories();

    //get categories by id
    CategoryDto getCategoryById(String id);

    //get catefory by title
    CategoryDto getCategoryByTitle(String title);

}
