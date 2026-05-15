package com.electronic.store.electronicstore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

    private String title;

    private String description;

    private  double price;

    private int quantity;

    private boolean isLive;

    private boolean inStock;

    private Date addedDate;

    private double discountPercentage;
}
