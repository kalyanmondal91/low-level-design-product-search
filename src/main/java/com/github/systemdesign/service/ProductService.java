package com.github.systemdesign.service;

import com.github.systemdesign.model.Product;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);
    List<Product> searchProduct(String searchString);
}
