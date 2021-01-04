package com.wleydsonlemos.dsdeliver.model.entity;

import com.wleydsonlemos.dsdeliver.model.enumeration.OrderStatus;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private Double latitude;
    private Double longitude;
    private Instant moment;
    private OrderStatus status;

    @ManyToMany
    @JoinTable(
            name = "tb_order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products = new HashSet<>();

}
