package com.inginerieSoftware.RestControllerExample.service;

import com.inginerieSoftware.RestControllerExample.model.Product;
import com.inginerieSoftware.RestControllerExample.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public Product getProduct(Long productId){
        return productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Not Found"));
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product updateProduct(Long productId, Product product){
        Product existingProduct = getProduct(productId);
        existingProduct.setProductName(product.getProductName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setColor(product.getColor());
        productRepository.save(existingProduct);
        return existingProduct;
    }

    public Product deleteProduct(Long productId){
        Product existingProduct = getProduct(productId);
        productRepository.deleteById(productId);
        return existingProduct;
    }

    public List<Product> getProductsByName(String productName){
        return productRepository.getProductsByName(productName);
    }
}
