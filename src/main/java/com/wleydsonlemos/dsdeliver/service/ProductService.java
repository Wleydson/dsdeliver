package com.wleydsonlemos.dsdeliver.service;

import com.wleydsonlemos.dsdeliver.dto.ProductDTO;
import com.wleydsonlemos.dsdeliver.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll(){
        return productRepository.findAllByOrderByPrice().stream().map(obj -> new ProductDTO(obj)).collect(Collectors.toList());
    }
}
