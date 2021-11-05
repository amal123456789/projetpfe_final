package com.projetPFE.crud.configelastic;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.ElasticsearchConfigurationSupport;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.convert.ElasticsearchCustomConversions;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import com.fasterxml.jackson.databind.util.Converter;
import com.projetPFE.crud.model.UserModel;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.projetPFE.crud.RepositoryElastic")
@ComponentScan(basePackages = { "com.projetPFE.crud.elasticService" })
public class Config {

    @Bean
    public RestHighLevelClient client() {
        ClientConfiguration clientConfiguration 
            = ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .build();

        return RestClients.create(clientConfiguration).rest();
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchRestTemplate(client());
    }
    
    
   /* @Bean
    @Override
    public ElasticsearchCustomConversions elasticsearchCustomConversions() {
      return new ElasticsearchCustomConversions(
        Arrays.asList(new AddressToMap(), new MapToAddress()));       
    }
    
    /*@WritingConverter                                                 
    static class AddressToMap implements Converter<UserModel, Map<String, Object>> {

      @Override
      public Map<String, Object> convert(UserModel source) {

        LinkedHashMap<String, Object> target = new LinkedHashMap<>();
        target.put("ciudad", source.getFirstName());
        // ...

        return target;
      }
    }

    @ReadingConverter                                                 
    static class MapToAddress implements Converter<Map<String, Object>, UserModel> {

      @Override
      public UserModel convert(Map<String, Object> source) {

        // ...
        return address;
      }
    }
    
    /*@Bean
    public Client elasticsearchClient() throws UnknownHostException {                 
      Settings settings = Settings.builder().put("cluster.name", "elasticsearch").build();
      TransportClient client = new PreBuiltTransportClient(settings);
      client.addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
      return client;
    }

    @Bean(name = {"elasticsearchOperations", "elasticsearchTemplate"})
    public ElasticsearchTemplate elasticsearchTemplate() throws UnknownHostException { 
    	return new ElasticsearchTemplate(elasticsearchClient());
    }*/
}