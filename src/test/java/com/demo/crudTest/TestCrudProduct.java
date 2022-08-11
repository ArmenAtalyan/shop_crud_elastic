package com.demo.crudTest;

import com.demo.model.Product;
import com.demo.service.ProductJpaService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestCrudProduct {

    @LocalServerPort
    private int port;

    private String baseUrl = "http://localhost";

    private static RestTemplate restTemplate;

    @Autowired
    private ProductJpaService jpaService;

    @BeforeAll
    public static void init() {
        restTemplate = new RestTemplate();
    }

    @BeforeEach
    public void setUp() {
        baseUrl = baseUrl.concat(":").concat(port + "").concat("/store");
    }

    @Test
    public void testAddProduct() {
        Product product = new Product("Electronic", 50, 60000);
        Product response = restTemplate.postForObject(baseUrl, product, Product.class);
        assert response != null;
        assertEquals("headset", response.getName());
        assertEquals(1, jpaService.findAll().size());
    }

    @Test
    @Sql(statements = "INSERT INTO products (name, count, price) VALUES ('AC', 1, 34000)", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "DELETE FROM products WHERE name='AC'", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void testGetProducts() {
        List productsList = restTemplate.getForObject(baseUrl, List.class);
        assert productsList != null;
        assertEquals(1, productsList.size());
        assertEquals(1, jpaService.findAll().size());
    }

    @Test
    @Sql(statements = "INSERT INTO products (name, count, price) VALUES ('CAR', 1, 334000)", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "DELETE FROM products WHERE id=1", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void testFindProductById() {
        Product product = restTemplate.getForObject(baseUrl + "/{id}", Product.class, 1);
        assertAll(
                () -> assertNotNull(product),
                () -> assertEquals(1, product.getId()),
                () -> assertEquals("CAR", product.getName())
        );
    }

    @Test
    @Sql(statements = "INSERT INTO products (name, count, price) VALUES ('shoes', 1, 1000)", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "DELETE FROM products WHERE id=1", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void testUpdateProduct() {
        Product product = new Product("shoes", 1, 1999);
        restTemplate.put(baseUrl + "/update/{id}", product, 2);
        Product productFromDB = jpaService.findByID(2);
        assertAll(
                () -> assertNotNull(productFromDB),
                () -> assertEquals(1999, productFromDB.getPrice())
        );
    }

    @Test
    @Sql(statements = "INSERT INTO products (name, count, price) VALUES ('book', 5, 1499)", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    public void testDeleteProduct() {
        int recordCount = jpaService.findAll().size();
        assertEquals(1, recordCount);
        restTemplate.delete(baseUrl + "/delete/{id}", 8);
        assertEquals(0, jpaService.findAll().size());
    }

}