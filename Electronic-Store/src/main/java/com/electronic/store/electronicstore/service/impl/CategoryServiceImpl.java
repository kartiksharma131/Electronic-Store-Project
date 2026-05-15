package com.electronic.store.electronicstore.service.impl;

import com.electronic.store.electronicstore.dtos.CategoryDto;
import com.electronic.store.electronicstore.entity.Category;
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
        Category category = dtoToEntity(categoryDto);
        Category savedCategory = categoryRepository.save(category);
        return entityToDto(savedCategory);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, String categoryId) {
        CategoryDto oldCategoryDto = getCategoryById(categoryId);

        if(oldCategoryDto==null){
            CategoryDto newCategory = createCategory(categoryDto);
            return newCategory;
        }
        else{
            Category category = dtoToEntity(categoryDto);
            category.setTitle(categoryDto.getTitle());
            category.setDescription(categoryDto.getDescription());
            Category updatedCategory = categoryRepository.save(category);
            return entityToDto(updatedCategory);
        }

    }

    @Override
    public void deleteCategory(String categoryId) {
        Category category =  categoryRepository.findById(categoryId).orElseThrow(()-> new RuntimeException("Category not found with id: "+categoryId));
        if(category!=null){
            categoryRepository.deleteById(categoryId);
        }

    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categoriesList = categoryRepository.findAll();
        List<CategoryDto> categoryDtosList = categoriesList.stream().map(category -> entityToDto(category)).toList();
        return categoryDtosList;
    }

    @Override
    public CategoryDto getCategoryById(String id) {
        Category category = categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found with id: "+id));
        return entityToDto(category);
    }

    @Override
    public CategoryDto getCategoryByTitle(String title) {
        Category category = categoryRepository.findCategoryByTitle(title);
        return entityToDto(category);
    }

    private CategoryDto entityToDto(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryId(category.getCategoryId());
        categoryDto.setTitle(category.getTitle());
        categoryDto.setDescription(category.getDescription());
        return categoryDto;
    }

    private Category dtoToEntity(CategoryDto categoryDto){
        Category category = new Category();
        category.setCategoryId(categoryDto.getCategoryId());
        category.setTitle(categoryDto.getTitle());
        category.setDescription(categoryDto.getDescription());
        return category;
    }
}

