package com.projects.product_inventory.controller;

import com.projects.product_inventory.model.Product;
import com.projects.product_inventory.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    ResponseEntity<?> addProduct(@Valid @RequestBody Product product){
        Product createdProduct = productService.addProduct(product);
        return ResponseEntity.status(201).body(createdProduct);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getProductById(@PathVariable String id) {
        Product existingProduct = productService.getProductById(id);
        if(existingProduct != null){
            return ResponseEntity.status(200).body(existingProduct);
        }
        return ResponseEntity.status(404).body("Product not found");
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateProductById(@PathVariable String id, @Valid @RequestBody Product product) {
        Product updateProduct = productService.updateProductById(id, product);
        if (updateProduct != null) {
            return ResponseEntity.status(200).body(updateProduct);
        }
        return ResponseEntity.status(404).body("Product not found");
    }

}
