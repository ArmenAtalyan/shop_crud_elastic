package com.demo.service;

import com.demo.model.Product;
import com.demo.repository.ProductJpaRepo;
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
        Product product = null;
        if(result.isPresent()){
            product = result.get();
        }else {
            throw new RuntimeException("Didn't find product with id: " + id);
        }
        return product;
    }

    public void save(Product product){
        productJpaRepo.save(product);
    }

    public String delete(int id){
        productJpaRepo.deleteById(id);
        return "Product with " + id + " is removed.";
    }
}
