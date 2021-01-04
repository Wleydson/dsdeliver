package com.wleydsonlemos.dsdeliver.dto;

import com.wleydsonlemos.dsdeliver.model.entity.Product;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDTO implements Serializable {

    private Long id;
    private String name;
    private Double price;
    private String description;
    private String imageUri;

    public ProductDTO(Long id, String name, Double price, String description, String imageUri) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageUri = imageUri;
    }

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.description = product.getDescription();
        this.imageUri = product.getImageUri();
    }
}
