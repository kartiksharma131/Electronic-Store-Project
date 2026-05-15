package com.electronic.store.electronicstore.repository;

import com.electronic.store.electronicstore.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,String> {

}
