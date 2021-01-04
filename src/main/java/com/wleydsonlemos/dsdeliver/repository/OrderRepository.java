package com.wleydsonlemos.dsdeliver.repository;

import com.wleydsonlemos.dsdeliver.model.entity.Order;
import com.wleydsonlemos.dsdeliver.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
