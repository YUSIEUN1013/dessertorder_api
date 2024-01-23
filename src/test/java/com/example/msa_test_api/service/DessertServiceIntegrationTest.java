package com.example.msa_test_api.service;

import com.example.msa_test_api.domain.Dessert;
import com.example.msa_test_api.repository.DessertRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    public void 삭제(){
        //Given
        Dessert dessert = new Dessert();
        dessert.setName("delete");
        dessert.setMenu("test");
        Long saveId = dessertService.Orders(dessert);

        //When
        dessertService.DeleteOreser(saveId);

        //Then
        List<Dessert> AfterDelete = dessertService.findOrders();
        assertThat(AfterDelete).doesNotContain(dessert);

    }

    @Test
    public void 전체주문조회(){
        //Given
        Dessert dessert1 = new Dessert();
        dessert1.setName("find1");
        dessert1.setMenu("test1");
        dessertService.Orders(dessert1);

        Dessert dessert2 = new Dessert();
        dessert2.setName("find2");
        dessert2.setMenu("test2");
        dessertService.Orders(dessert2);

        //When
        List<Dessert> result = dessertService.findOrders();

        //Then
        assertThat(result).isNotNull();
        //assertThat(result.size()).isEqualTo(1);
        assertThat(result).contains(dessert1, dessert2);
    }

    @Test
    public void 아이디조회() {
        //Given
        Dessert dessert = new Dessert();
        dessert.setName("GetByID");
        dessert.setMenu("test");
        dessertService.Orders(dessert);
        Long OrderId = dessert.getId();

        //When
        Dessert result = dessertService.findOne(OrderId).get();

        //Then
        assertThat(result).isEqualTo(dessert);
    }

}
