package com.example.msa_test_api.controller;

import com.example.msa_test_api.domain.Dessert;
import com.example.msa_test_api.service.DessertService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class DessertController {

    private final DessertService dessertService;

    public DessertController(DessertService dessertService) {
        this.dessertService = dessertService;
    }

    @GetMapping("/test")
    @ResponseBody
    public List<Dessert> dessertList() {

        List<Dessert> result = null;

        try {
            result = dessertService.findOrders();
            System.out.println("디저트 주문 목록 success");
        } catch (Exception e) {
            System.out.println("디저트 주문 목록 불러오기 fail");
            System.out.println(e.getMessage());
        }

        return result;
    }

    @PostMapping("/posts")
    @JsonProperty("Dessert")
    public void insertDessert(@RequestBody Dessert dessert){
        try {
            dessertService.Orders(dessert);
            System.out.println("디저트 주문 추가하기 success");
        }catch (Exception e){
            System.out.println("디저트 주문 추가하기 fail");
            System.out.println(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDessert(@PathVariable Long id){
        try {
            dessertService.DeleteOreser(id);
            System.out.println("디저트 주문 삭제하기 success");
        }catch (Exception e){
            System.out.println("디저트 주문 삭제하기 fail");
            System.out.println(e.getMessage());
        }
    }
}
