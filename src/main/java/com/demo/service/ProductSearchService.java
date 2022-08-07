package com.demo.service;

import com.demo.model.Product;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductSearchService {

    private final ProductJpaService productJpaService;

    public ProductSearchService(ProductJpaService productJpaService) {
        this.productJpaService = productJpaService;
    }

    @Query("FROM products WHERE name LIKE %:name%")
    public List<Product> findProductsByNameStartingWith(@Param("name") String inputString) {
        List<Product> allProducts = new ArrayList<>(productJpaService.findAll());
        List<Product> findingNames = new ArrayList<>();
        for (Product product : allProducts) {
            if(product.getName().startsWith(String.valueOf(inputString))){
                findingNames.add(product);
            }
        }
        return findingNames;
    }

}
