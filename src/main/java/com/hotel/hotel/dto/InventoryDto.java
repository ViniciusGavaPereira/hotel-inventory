package com.hotel.hotel.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.hotel.hotel.entities.Inventory;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class InventoryDto {

    private String product;
    private int quantity;
    private float cost;

    public InventoryDto() {

    }

    public InventoryDto(Inventory inventory) {
        product = inventory.getProduct();
        quantity = inventory.getQuantity();
        cost = inventory.getCost();
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

    public static List<InventoryDto> inventoryConverter(List<Inventory> products) {
        return products.stream().map(InventoryDto::new).collect(Collectors.toList());
    }

}
