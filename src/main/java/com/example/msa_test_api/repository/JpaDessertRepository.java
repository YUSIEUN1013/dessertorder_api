package com.example.msa_test_api.repository;

import com.example.msa_test_api.domain.Dessert;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JpaDessertRepository implements DessertRepository{

    private final EntityManager em;

    public JpaDessertRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Dessert save(Dessert dessert) {
        em.persist(dessert);
        return dessert;
    }

    @Override
    public Optional<Dessert> findById(Long id) {
        Dessert dessert = em.find(Dessert.class, id);
        return Optional.ofNullable(dessert);
    }

    @Override
    public List<Dessert> findAll() {
        return em.createQuery("select d from Dessert d", Dessert.class)
                .getResultList();
    }

    @Override
    public Long DeleteOrder(Long id) {
        Dessert dessert = em.find(Dessert.class, id);
        em.remove(dessert);
        return id;
    }
}
