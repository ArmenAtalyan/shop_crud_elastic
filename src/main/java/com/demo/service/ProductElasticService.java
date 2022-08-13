package com.demo.service;

import com.demo.model.Product;
import com.demo.repositoryElastic.ProductElasticRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductElasticService {

    private final ProductElasticRepo productElasticRepo;

    @Autowired
    public ProductElasticService(ProductElasticRepo productElasticRepo) {
        this.productElasticRepo = productElasticRepo;
    }

    public List<Product> findAllResults(String text){
        return productElasticRepo.findAllByInput(text);
    }
}
