package com.inginerieSoftware.RestControllerExample.repository;

import com.inginerieSoftware.RestControllerExample.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM product_inventory WHERE product_name = ?1", nativeQuery = true)
    List<Product> getProductsByName(String productName);
}
