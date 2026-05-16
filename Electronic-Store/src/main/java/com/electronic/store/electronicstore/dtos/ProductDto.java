package com.electronic.store.electronicstore.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private String id;

    @NotBlank(message = "Title cannot be blank")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;

    @NotBlank(message = "Description cannot be blank")
    @Size(min = 10, max = 500, message = "Description must be between 10 and 500 characters")
    private String description;

    @Positive(message = "Price must be positive")
    private double price;

    @Positive(message = "Quantity must be positive")
    private int quantity;

    private Boolean isLive;

    private Boolean inStock;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date addedDate;

    @Positive(message = "Discount percentage must be positive")
    private double discountPercentage;
}
