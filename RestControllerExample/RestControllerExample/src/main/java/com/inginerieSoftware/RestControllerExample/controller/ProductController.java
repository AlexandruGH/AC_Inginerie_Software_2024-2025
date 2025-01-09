package com.inginerieSoftware.RestControllerExample.controller;

import com.inginerieSoftware.RestControllerExample.model.Product;
import com.inginerieSoftware.RestControllerExample.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    // insert product into database
    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        Product savedProduct = productService.saveProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    // get single product by its id
    @GetMapping("/product")
    public ResponseEntity<Product> getProduct(@RequestParam(name = "productId") Long productId){
        Product product = productService.getProduct(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    // get all products
    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    //update an existing product
    @PutMapping("/product/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long productId, @RequestBody Product product){
        Product updateProduct = productService.updateProduct(productId, product);
        return new ResponseEntity<>(updateProduct, HttpStatus.OK);
    }

    //delete an existing product
    @DeleteMapping("/product/{productId}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long productId){
        Product deletedProduct = productService.deleteProduct(productId);
        return new ResponseEntity<>(deletedProduct, HttpStatus.OK);
    }

    // get product by name using raw sql statement
    @GetMapping("/products-by-name/{productName}")
    public List<Product> getProductsByName(@PathVariable String productName){
        return productService.getProductsByName(productName);
    }
}
