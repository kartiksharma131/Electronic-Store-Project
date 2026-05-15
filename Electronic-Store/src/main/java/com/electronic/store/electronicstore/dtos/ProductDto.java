package com.electronic.store.electronicstore.dtos;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private String id;

    @Size(min = 4, max = 100, message = "Product title must be between 4 and 100 characters")
    private String title;

    @Size(min = 10, max = 500, message = "Product description must be between 10 and 500 characters")
    private String description;

    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    private  double price;

    @Min(value = 0, message = "Quantity cannot be negative")
    private int quantity;


    private boolean isLive;

    private boolean inStock;

    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Date addedDate;

    @DecimalMin(value = "0.0", inclusive = true, message = "Discount percentage cannot be negative")
    @DecimalMax(value = "100.0", inclusive = true, message = "Discount percentage cannot be greater than 100")
    private double discountPercentage;
}
