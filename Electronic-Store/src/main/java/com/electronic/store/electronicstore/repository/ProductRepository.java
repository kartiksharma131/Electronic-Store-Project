package com.electronic.store.electronicstore.repository;

import com.electronic.store.electronicstore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {

    // Change this method name to match the "isLive" field:
    List<Product> findAllByIsLiveTrue();

    List<Product> findAllByDiscountPercentageGreaterThan(double discountPercentage);

    List<Product> findByTitleContaining(String title);
}
