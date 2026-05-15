package com.electronic.store.electronicstore.repository;

import com.electronic.store.electronicstore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByTitleContaining(String subTitle);

    List<Product> findAllByLiveTrue();

    List<Product> findAllByDiscountPercentageGreaterThan(double discountPercentage);
}
