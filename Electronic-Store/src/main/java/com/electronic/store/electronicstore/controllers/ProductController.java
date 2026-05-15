package com.electronic.store.electronicstore.controllers;

import com.electronic.store.electronicstore.dtos.ProductDto;
import com.electronic.store.electronicstore.service.interfaces.ProductService;
import com.electronic.store.electronicstore.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/create")
    public ProductDto createProduct(ProductDto productDto){
        return productService.createProduct(productDto);
    }

    @PutMapping("/update/{productId}")
    public ProductDto updateProduct(@RequestBody ProductDto productDto, @PathVariable String productId){
        return productService.updateProduct(productDto,productId);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        productService.deleteProduct(id);
    }

    @GetMapping("/getLiveProucts")
    public List<ProductDto> getAllLiveProducts(){
        return productService.getAllLiveProducts();
    }

    @GetMapping("/getAllProducts")
    public List<ProductDto> getAllProducts(){
        return productService.getAllProducts();
    }


    @GetMapping("/getProdcutById/{id}")
    public ProductDto getProductById(@PathVariable String id){
        return productService.getSingleProduct(id);
    }

    @GetMapping("/getProductsWithDiscountGreaterThan/{discountPercentage}")
    public List<ProductDto> getProductsWithDiscountGreaterThan(@PathVariable double discountPercentage) {
        return productService.getProductsWithDiscountGreaterThan(discountPercentage);
    }

    @GetMapping("/searchProductsByTitle/{subtitle}")
    public List<ProductDto> searchProductsByTitle(@PathVariable String subtitle) {
        return productService.searchProductByTitle(subtitle);
    }
}
