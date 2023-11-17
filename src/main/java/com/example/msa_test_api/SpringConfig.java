package com.example.msa_test_api;

import com.example.msa_test_api.repository.DessertRepository;
import com.example.msa_test_api.repository.JpaDessertRepository;
import com.example.msa_test_api.service.DessertService;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;
    private final EntityManager em;

    public SpringConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }

    @Bean
    public DessertService dessertService() {
        return new DessertService(dessertRepository());
    }

    @Bean
    public DessertRepository dessertRepository(){
        return new JpaDessertRepository(em);
    }
}
