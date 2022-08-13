package com.demo.controller;

import com.demo.model.Product;
import com.demo.service.ProductJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store")
public class ProductController {

    private final ProductJpaService productJpaService;

    @Autowired
    public ProductController(ProductJpaService productJpaService) {
        this.productJpaService = productJpaService;
    }

    @GetMapping("/products")
    public List<Product> showProductList(){
        return productJpaService.findAll();
    }

    @GetMapping("/products/{id}")
    public Product findProduct(@PathVariable int id){
        Product product = productJpaService.findByID(id);
        if (product == null){
            throw new RuntimeException("Employee with id " + id + " not found.");
        }
        return productJpaService.findByID(id);
    }

    @PostMapping("/products/add")
    public Product saveProduct(@RequestBody Product product){
        productJpaService.save(product);
        return product;
    }

    @PostMapping("/products/update")
    public Product updateProduct(@RequestBody Product product){
        productJpaService.save(product);
        return product;
    }

    @PostMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        Product product = productJpaService.findByID(id);
        if (product == null){
            throw new RuntimeException("Employee with id " + id + " not found");
        }
        productJpaService.delete(id);
        return "Product with " + id + " is removed.";
    }

}
