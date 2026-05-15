package com.electronic.store.electronicstore.service.impl;

import com.electronic.store.electronicstore.dtos.ProductDto;
import com.electronic.store.electronicstore.entity.Product;
import com.electronic.store.electronicstore.exceptions.ResourceNotFoundException;
import com.electronic.store.electronicstore.repository.ProductRepository;
import com.electronic.store.electronicstore.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    public ProductServiceImpl(@Autowired ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = productRepository.save(dtoToEntity(productDto));
        return entityToDto(product);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, String id) {
        Product existingProduct = productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found with id: "+id));
        if(existingProduct!=null){
            existingProduct.setTitle(productDto.getTitle());
            existingProduct.setDescription(productDto.getDescription());
            existingProduct.setPrice(productDto.getPrice());
            existingProduct.setQuantity(productDto.getQuantity());
            existingProduct.setLive(productDto.isLive());
            existingProduct.setInStock(productDto.isInStock());
            existingProduct.setAddedDate(productDto.getAddedDate());
            existingProduct.setDiscountPercentage(productDto.getDiscountPercentage());
            Product updatedProduct = productRepository.save(existingProduct);
            return entityToDto(updatedProduct);
        }
        else{
            Product newProduct = productRepository.save(dtoToEntity(productDto));
            return entityToDto(newProduct);
        }
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductDto> getAllLiveProducts() {
        List<Product> liveProductList = productRepository.findAllByLiveTrue();
        return liveProductList.stream().map(product -> entityToDto(product)).toList();
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> allProductList = productRepository.findAll();
        return allProductList.stream().map(product -> entityToDto(product)).toList();
    }

    @Override
    public ProductDto getSingleProduct(String productId) {
        Product product = productRepository.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product not found with id: "+productId));
        return entityToDto(product);
    }

    @Override
    public List<ProductDto> getProductsWithDiscountGreaterThan(double discountPercentage) {
        List<Product> discountedProductsList = productRepository.findAllByDiscountPercentageGreaterThan(discountPercentage);
        return discountedProductsList.stream().map(product -> entityToDto(product)).toList();
    }

    @Override
    public List<ProductDto> searchProductByTitle(String title) {
        List<Product> searchedProductsList = productRepository.findByTitleContaining(title);
        return searchedProductsList.stream().map(product -> entityToDto(product)).toList();
    }

    private ProductDto entityToDto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setTitle(product.getTitle());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setQuantity(product.getQuantity());
        productDto.setLive(product.isLive());
        productDto.setInStock(product.isInStock());
        productDto.setAddedDate(product.getAddedDate());
        productDto.setDiscountPercentage(product.getDiscountPercentage());
        return productDto;
    }

    private Product dtoToEntity(ProductDto productDto){
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
        product.setLive(productDto.isLive());
        product.setInStock(productDto.isInStock());
        product.setAddedDate(productDto.getAddedDate());
        product.setDiscountPercentage(productDto.getDiscountPercentage());
        return product;
    }
}
