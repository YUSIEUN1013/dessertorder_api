package com.example.msa_test_api.service;

import com.example.msa_test_api.domain.Dessert;
import com.example.msa_test_api.repository.DessertRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class DessertService {

    private final DessertRepository dessertRepository;

    public DessertService(DessertRepository dessertRepository) {
        this.dessertRepository = dessertRepository;
    }

    public Long Orders(Dessert dessert){
        dessertRepository.save(dessert);
        return dessert.getId();
    }

    public Optional<Dessert> findOne(Long id){
        return dessertRepository.findById(id);
    }

    public List<Dessert> findOrders() {
        return dessertRepository.findAll();
    }

    public Long DeleteOreser(Long id){
        return dessertRepository.DeleteOrder(id);
    }
}
