package com.wleydsonlemos.dsdeliver.dto;

import com.wleydsonlemos.dsdeliver.model.entity.Order;
import com.wleydsonlemos.dsdeliver.model.enumeration.OrderStatus;
import lombok.Data;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class OrderDTO {

    private Long id;
    private String address;
    private Double latitude;
    private Double longitude;
    private Instant moment;
    private OrderStatus status;
    private List<ProductDTO> products;

    public OrderDTO() {
    }

    public OrderDTO(Long id, String address, Double latitude, Double longitude, Instant moment, OrderStatus status) {
        this.id = id;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.moment = moment;
        this.status = status;
    }

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.address = order.getAddress();
        this.latitude = order.getLatitude();
        this.longitude = order.getLongitude();
        this.moment = order.getMoment();
        this.status = order.getStatus();
        this.products = order.getProducts().stream().map(obj -> new ProductDTO(obj)).collect(Collectors.toList());
    }
}
