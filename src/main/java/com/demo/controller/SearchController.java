package com.demo.controller;

import com.demo.model.Product;
import com.demo.repository.ProductElasticRepo;
import com.demo.service.ProductElasticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/store/search")
public class SearchController {

    private final ProductElasticService elasticService;

    @Autowired
    public SearchController(ProductElasticService elasticService) {
        this.elasticService = elasticService;
    }

    @GetMapping(value = "/{text}")
    public List<Product> getAllResults(@PathVariable String text) {
        return elasticService.findAllResults(text);
    }
}
