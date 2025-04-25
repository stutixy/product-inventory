package com.projects.product_inventory.service;
import com.projects.product_inventory.model.Product;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.rmi.server.UID;
import  java.util.*;

@Service
public class ProductService {

    private final Map<String, Product> productMap = new HashMap<>();

    public Product addProduct(Product product) {
        String id = UUID.randomUUID().toString();
        product.setId(id);
        productMap.put(id, product);
        return product;
    }

    public Product getProductById( String id) {
        return this.productMap.get(id);
    }

    public Product updateProductById(String id, Product product){
        Product existingProduct = productMap.get(id);
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setQuantity(product.getQuantity());
            return existingProduct;
        }
        return null;
    }


}
