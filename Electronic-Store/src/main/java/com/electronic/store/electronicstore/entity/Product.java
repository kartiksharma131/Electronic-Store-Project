package com.electronic.store.electronicstore.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    private String id;

    @NotBlank
    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @NotBlank
    @Column(name = "description", length = 500, nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "is_live")
    private Boolean isLive;

    @Column(name = "in_stock")
    private Boolean inStock;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "added_date")
    private Date addedDate;

    @Column(name = "discount_percentage")
    private double discountPercentage;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;
}
