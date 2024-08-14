package com.hotel.hotel.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orders")
public class Orders {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "OrderNumber")
    private Integer orderNumber;
    @Column(name = "Product")
    private String product;
    @Column(name = "Price")
    private float price;
    @Column(name = "Quantity")
    private Integer quantity;

    public Orders() {
    }

    public Orders(long id, Integer orderNumber, String product, float price, Integer quantity) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.product = product;
        this.price = price;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
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

    @Override
    public String toString() {
        return "Order [id=" + id + ", OrderNumber=" + orderNumber + ", product=" + product + ", price=" + price
                + ", quantity=" + quantity + "]";
    }

}
