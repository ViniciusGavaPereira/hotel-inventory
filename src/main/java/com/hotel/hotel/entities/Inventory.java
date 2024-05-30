package com.hotel.hotel.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;

@Entity
@Table(name = "Inventory")
public class Inventory {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Product")
    private String product;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "Cost")
    private float cost;

    public Inventory() {
    }

    public Inventory(String product, int quantity, float cost) {
        this.product = product;
        this.quantity = quantity;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public void addQuantity(int quant) {
        this.quantity = quantity + quant;
    }

    public void removeQuantity(int quant) {
        this.quantity = quantity - quant;
    }

}
