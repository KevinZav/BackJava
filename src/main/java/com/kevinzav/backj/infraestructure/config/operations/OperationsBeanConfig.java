package com.kevinzav.backj.infraestructure.config.operations;

import com.kevinzav.backj.application.operations.OperationsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OperationsBeanConfig {
    @Bean
    public OperationsService operationsService(RestTemplate restTemplate) {
        return new OperationsService(restTemplate);
    }
}
