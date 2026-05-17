package com.electronic.store.electronicstore.service.interfaces;

import com.electronic.store.electronicstore.dtos.ProductDto;

import java.util.List;

public interface ProductService {
    //create
    ProductDto createProduct(ProductDto productDto);

    //update
    ProductDto updateProduct(ProductDto productDto, String id);

    //delete
    void deleteProduct(String id);

    //getAllLiveProduct
    List<ProductDto> getAllLiveProducts();

    //getAllProducts
    List<ProductDto> getAllProducts();

    //getSingleProduct
    ProductDto getSingleProduct(String productId);

    //get products with discount > x%
    List<ProductDto> getProductsWithDiscountGreaterThan(double discountPercentage);

    //search product by title
    List<ProductDto> searchProductByTitle(String title);

    ProductDto createWithCategory(ProductDto productDto, String categoryId);

    ProductDto addCategoryToProduct(String productId, String categoryId);
}
