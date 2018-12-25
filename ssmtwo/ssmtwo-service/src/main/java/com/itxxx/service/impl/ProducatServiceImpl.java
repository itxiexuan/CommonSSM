package com.itxxx.service.impl;

import com.itxxx.dao.ProductDao;
import com.itxxx.domain.Product;
import com.itxxx.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ProducatServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public List<Product> findAll() throws Exception {
        List<Product> list = productDao.findAll();
        return list;
    }

    @Override
    public void saveProduct(Product product) {
        productDao.saveProduct(product);
    }
}
