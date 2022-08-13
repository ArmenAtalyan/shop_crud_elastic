package com.demo.repositoryJPA;

import com.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaRepo extends JpaRepository<Product, Integer> {
}
