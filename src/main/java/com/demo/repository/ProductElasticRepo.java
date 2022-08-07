package com.demo.repository;

import com.demo.model.Product;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ProductElasticRepo extends ElasticsearchRepository<Product, Integer> {

    @Query("{\"match\":{\"name\":\"?0\"}}")
    List<Product> findAllByInput(String name);
}
