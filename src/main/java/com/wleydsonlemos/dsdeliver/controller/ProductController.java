package com.wleydsonlemos.dsdeliver.controller;

import com.wleydsonlemos.dsdeliver.dto.ProductDTO;
import com.wleydsonlemos.dsdeliver.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll(){
        List<ProductDTO> productDTOS = productService.findAll();
        return ResponseEntity.ok(productDTOS);
    }

}
