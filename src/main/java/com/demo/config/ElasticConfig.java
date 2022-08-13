package com.demo.config;

import jakarta.annotation.Resource;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.env.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.client.erhlc.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.client.erhlc.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;


//@Configuration
//@PropertySource(value = "elasticSearch.properties")
public class ElasticConfig {

//        @Resource
//        private Environment environment;
//
//        @Bean
//        public Client client() {
//            TransportClient client = new TransportClient();
//            TransportAddress address = new InetSocketTransportAddress(
//                    environment.getProperty("elasticsearch.host"),
//                    Integer.parseInt(environment.getProperty("elasticsearch.port"))
//            );
//            client.addTransportAddress(address);
//            return client;
//        }
//
//        @Bean
//        public ElasticsearchOperations elasticsearchTemplate() {
//            return new ElasticsearchTemplate(client());
//        }

}
