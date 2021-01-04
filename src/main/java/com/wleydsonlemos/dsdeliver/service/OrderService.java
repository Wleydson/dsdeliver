package com.wleydsonlemos.dsdeliver.service;

import com.wleydsonlemos.dsdeliver.dto.OrderDTO;
import com.wleydsonlemos.dsdeliver.model.entity.Order;
import com.wleydsonlemos.dsdeliver.model.entity.Product;
import com.wleydsonlemos.dsdeliver.repository.OrderRepository;
import com.wleydsonlemos.dsdeliver.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll(){
        return orderRepository.findOrdersWithProducts().stream().map(obj -> new OrderDTO(obj)).collect(Collectors.toList());
    }

    @Transactional
    public OrderDTO insert(OrderDTO orderDTO){
        Order order = modelMapper.map(orderDTO, Order.class);
        order.setProducts(new HashSet<>());
        orderDTO.getProducts().stream().forEach(productDTO -> {
            Product product = productRepository.getOne(productDTO.getId());
            order.getProducts().add(product);
        });
        Order entity = orderRepository.save(order);

        return new OrderDTO(entity);
    }
}
