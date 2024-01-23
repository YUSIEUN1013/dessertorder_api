package com.example.msa_test_api.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DessertTest {

    @Test
    @DisplayName("Dessert Domain Test")
    public void CreateOrder() {
        //Given
        Dessert dessert = new Dessert();
        dessert.setName("Domain");
        dessert.setMenu("test");

        //when, then
        assertEquals("Domain", dessert.getName());
        assertEquals("test", dessert.getMenu());
    }

}
