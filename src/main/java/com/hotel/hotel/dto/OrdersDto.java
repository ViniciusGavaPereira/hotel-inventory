package com.hotel.hotel.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.hotel.hotel.entities.Orders;

public class OrdersDto {

    private long id;
    private Integer OrderNumber;
    private String product;
    private float price;
    private Integer quantity;

    public OrdersDto() {
    }

    public OrdersDto(Orders orders) {
        id = orders.getId();
        OrderNumber = orders.getOrderNumber();
        product = orders.getProduct();
        price = orders.getPrice();
        quantity = orders.getQuantity();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        OrderNumber = orderNumber;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public static List<OrdersDto> ordersConverter(List<Orders> products) {
        return products.stream().map(OrdersDto::new).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Orders:\nId: " + id + "\nOrderNumber: " + OrderNumber + "\nProduct: " + product + "\nPrice: " + price
                + "\nQuantity: " + quantity;
    }

}
