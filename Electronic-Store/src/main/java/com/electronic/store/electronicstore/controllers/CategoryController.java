package com.electronic.store.electronicstore.controllers;

import com.electronic.store.electronicstore.dtos.CategoryDto;
import com.electronic.store.electronicstore.service.interfaces.CategoryService;
import com.electronic.store.electronicstore.service.interfaces.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/create")
    public CategoryDto createCategory(@Valid @RequestBody CategoryDto categoryDto){
        UUID uuid = UUID.randomUUID();
        categoryDto.setCategoryId(uuid.toString());
        return categoryService.createCategory(categoryDto);
    }

    @PutMapping("/update/{id}")
    public CategoryDto updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable("id") String categoryId){
        return categoryService.updateCategory(categoryDto, categoryId);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable String id){
        categoryService.deleteCategory(id);
    }

    @GetMapping("/getAllCategories")
    public List<CategoryDto> getAllCategories(){
        List<CategoryDto> categoryDtosList = categoryService.getAllCategories();
        return categoryDtosList;
    }

    @GetMapping("/getCategoryById/{id}")
    public CategoryDto getCategoryById(@PathVariable String id){
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/getCategoryByTitle/{title}")
    public CategoryDto getCategoryByTitle(@PathVariable String title) {
        return categoryService.getCategoryByTitle(title);
    }

}
