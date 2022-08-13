package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.demo.repositoryJPA")
@EnableElasticsearchRepositories("com.demo.repositoryElastic")
public class OnShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnShopApplication.class, args);
	}

}
