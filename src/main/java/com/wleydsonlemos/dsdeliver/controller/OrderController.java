package com.wleydsonlemos.dsdeliver.controller;

import com.wleydsonlemos.dsdeliver.dto.OrderDTO;
import com.wleydsonlemos.dsdeliver.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAll(){
        List<OrderDTO> orderDTOS = service.findAll();
        return ResponseEntity.ok(orderDTOS);
    }

}
