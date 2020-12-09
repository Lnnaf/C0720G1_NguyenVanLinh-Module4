package com.project.service;

import com.project.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void save(Product product);
    Product findById(int id);
    void remove(int id);
    int randomId();
}
