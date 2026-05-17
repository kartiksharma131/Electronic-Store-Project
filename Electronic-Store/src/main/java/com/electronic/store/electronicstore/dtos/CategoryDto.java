package com.electronic.store.electronicstore.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    private String categoryId;

    @NotBlank(message = "Category title cannot be blank")
    @Size(min = 4, max = 100, message = "Category title must be between 4 and 100 characters")
    private String title;

    @Size(min = 10, max = 300, message = "Category description must be between 10 and 300 characters")
    private String description;

    private List<ProductDto> productDtoList;
}
