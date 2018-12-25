package com.itxxx.service;

import com.itxxx.domain.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAll() throws Exception;
    void saveProduct(Product product);
}
