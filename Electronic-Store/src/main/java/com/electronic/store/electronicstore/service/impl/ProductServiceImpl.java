package com.electronic.store.electronicstore.service.impl;

import com.electronic.store.electronicstore.dtos.CategoryDto;
import com.electronic.store.electronicstore.dtos.ProductDto;
import com.electronic.store.electronicstore.entity.Category;
import com.electronic.store.electronicstore.entity.Product;
import com.electronic.store.electronicstore.exceptions.ResourceNotFoundException;
import com.electronic.store.electronicstore.repository.CategoryRepository;
import com.electronic.store.electronicstore.repository.ProductRepository;
import com.electronic.store.electronicstore.service.interfaces.CategoryService;
import com.electronic.store.electronicstore.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public ProductServiceImpl(@Autowired ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        UUID uuid = UUID.randomUUID();
        productDto.setId(uuid.toString());
        Product product = dtoToEntity(productDto);
        Product savedProduct = productRepository.save(product);
        return entityToDto(savedProduct);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, String id) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));

        // Update only non-null fields (partial update pattern)
        if (productDto.getTitle() != null) {
            existingProduct.setTitle(productDto.getTitle());
        }
        if (productDto.getDescription() != null) {
            existingProduct.setDescription(productDto.getDescription());
        }
        if (productDto.getPrice() > 0) {
            existingProduct.setPrice(productDto.getPrice());
        }
        if (productDto.getQuantity() > 0) {
            existingProduct.setQuantity(productDto.getQuantity());
        }
        if (productDto.getIsLive() != null) {
            existingProduct.setIsLive(productDto.getIsLive());
        }
        if (productDto.getInStock() != null) {
            existingProduct.setInStock(productDto.getInStock());
        }
        if (productDto.getAddedDate() != null) {
            existingProduct.setAddedDate(productDto.getAddedDate());
        }
        if (productDto.getDiscountPercentage() >= 0) {
            existingProduct.setDiscountPercentage(productDto.getDiscountPercentage());
        }

        Product updatedProduct = productRepository.save(existingProduct);
        return entityToDto(updatedProduct);
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductDto> getAllLiveProducts() {
        // Update the method call here:
        List<Product> liveProductList = productRepository.findAllByIsLiveTrue();
        return liveProductList.stream().map(product -> entityToDto(product)).toList();
    }


    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> allProductList = productRepository.findAll();
        return allProductList.stream().map(product -> entityToDto(product)).toList();
    }

    @Override
    public ProductDto getSingleProduct(String productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId));
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

    @Override
    public ProductDto addCategoryToProduct(String productId, String categoryId){
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId));
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + categoryId));

        product.setCategory(category);
        Product updatedProduct = productRepository.save(product);
        return entityToDto(updatedProduct);
    }

    private ProductDto entityToDto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setTitle(product.getTitle());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setQuantity(product.getQuantity());
        productDto.setIsLive(product.getIsLive());
        productDto.setInStock(product.getInStock());
        productDto.setAddedDate(product.getAddedDate());
        productDto.setDiscountPercentage(product.getDiscountPercentage());
        if(product.getCategory()!=null){
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setCategoryId(product.getCategory().getCategoryId());
            categoryDto.setTitle(product.getCategory().getTitle());
            categoryDto.setDescription(product.getCategory().getDescription());
            productDto.setCategoryDto(categoryDto);
        }
        return productDto;
    }

    private Product dtoToEntity(ProductDto productDto){
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
        product.setIsLive(productDto.getIsLive());
        product.setInStock(productDto.getInStock());
        product.setAddedDate(productDto.getAddedDate());
        product.setDiscountPercentage(productDto.getDiscountPercentage());

        return product;
    }

    public ProductDto createWithCategory(ProductDto productDto, String categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + categoryId));

        UUID uuid = UUID.randomUUID();
        productDto.setId(uuid.toString());
        Product product = dtoToEntity(productDto);
        product.setCategory(category);
        Product savedProduct = productRepository.save(product);

        return entityToDto(savedProduct);
    }
}
