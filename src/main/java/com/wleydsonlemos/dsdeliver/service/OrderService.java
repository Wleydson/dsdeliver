package com.wleydsonlemos.dsdeliver.service;

import com.wleydsonlemos.dsdeliver.dto.OrderDTO;
import com.wleydsonlemos.dsdeliver.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll(){
        return orderRepository.findOrdersWithProducts().stream().map(obj -> new OrderDTO(obj)).collect(Collectors.toList());
    }
}
