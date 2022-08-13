package com.demo.repositoryElastic;

import com.demo.model.Product;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductElasticRepo extends ElasticsearchRepository<Product, Integer> {

    @Query("{\"match\":{\"name\":\"?0\"}}")
    List<Product> findAllByInput(String name);
}
