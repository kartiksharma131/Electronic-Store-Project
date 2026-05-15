package com.electronic.store.electronicstore.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    @NotNull(message = "Category Id cannot be null")
    private String categoryId;

    @NotBlank(message = "Category title cannot be blank")
    @Min(value = 4, message = "Category title must be at least 4 characters long")
    @Max(value = 100, message = "Category title must be at most 100 characters long")
    private String title;

    @Min(value = 10, message = "Category description must be at least 10 characters long")
    @Max(value = 300, message = "Category description must be at most 300 characters long")
    private String description;

}
