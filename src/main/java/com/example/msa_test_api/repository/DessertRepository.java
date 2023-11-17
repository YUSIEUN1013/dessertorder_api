package com.example.msa_test_api.repository;

import com.example.msa_test_api.domain.Dessert;

import java.util.List;
import java.util.Optional;

public interface DessertRepository {

    Dessert save(Dessert dessert);
    Optional<Dessert> findById(Long id);
    List<Dessert> findAll();
    Long DeleteOrder(Long id);

}
