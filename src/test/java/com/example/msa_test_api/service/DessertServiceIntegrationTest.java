package com.example.msa_test_api.service;

import com.example.msa_test_api.domain.Dessert;
import com.example.msa_test_api.repository.DessertRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
@Transactional
public class DessertServiceIntegrationTest {

    @Autowired
    DessertService dessertService;
    @Autowired
    DessertRepository dessertRepository;

    @Test
    public void 주문() throws Exception {
        //Given
        Dessert dessert = new Dessert();
        dessert.setName("spring");
        dessert.setMenu("boot");

        //When
        Long saveId = dessertService.Orders(dessert);

        //Then
        Dessert findDessert = dessertRepository.findById(saveId).get();
        assertEquals(dessert.getName(), findDessert.getName());
        assertEquals(dessert.getMenu(), findDessert.getMenu());
    }

}
