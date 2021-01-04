package com.wleydsonlemos.dsdeliver.repository;

import com.wleydsonlemos.dsdeliver.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByOrderByPrice();
}
