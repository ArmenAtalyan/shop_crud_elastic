package com.demo.controller;

import com.demo.model.Product;
import com.demo.repository.ProductElasticRepo;
import com.demo.service.ProductSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/search")
public class SearchController {

    private final ProductElasticRepo elasticRepo;

    @Autowired
    public SearchController(ProductElasticRepo elasticRepo) {
        this.elasticRepo = elasticRepo;
    }

    @GetMapping(value = "/{text}")
    public List<Product> getAllResults(@PathVariable String text) {
        return elasticRepo.findAllByInput(text);
    }
}
