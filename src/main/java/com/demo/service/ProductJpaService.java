package com.demo.service;

import com.demo.model.Product;
import com.demo.repositoryJPA.ProductJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductJpaService {
    private final ProductJpaRepo productJpaRepo;

    @Autowired
    public ProductJpaService(ProductJpaRepo productJpaRepo) {
        this.productJpaRepo = productJpaRepo;
    }

    public List<Product> findAll(){
        return productJpaRepo.findAll();
    }

    public Product findByID(int id){
        Optional<Product> result = productJpaRepo.findById(id);
        return result.get();
    }

    public void save(Product product){
        productJpaRepo.save(product);
    }

    public String delete(int id){
        productJpaRepo.deleteById(id);
        return "Product with " + id + " is removed.";
    }
}
