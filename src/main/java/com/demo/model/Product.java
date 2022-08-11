package com.demo.model;

import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;


@Entity
@Table(name = "products")
@Document(indexName = "product")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "count")
    private int count;
    @Column(name = "price")
    private int price;

    public Product(String name, int count, int price) {;
        this.name = name;
        this.count = count;
        this.price = price;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}