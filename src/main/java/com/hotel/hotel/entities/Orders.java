package com.hotel.hotel.entities;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Orders")
public class Orders {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "OrderNumber")
    private Integer orderNumber;
    @Column(name = "Price")
    private float price;
    @Column(name = "Quantity")
    private Integer quantity;
    @NotBlank
    @Column(name = "fkIdInventory")
    private int fkIdInventory;
    @NotBlank
    @Column(name = "FkIdSchedule")
    private int fkIdSchedule;

    public Orders() {
    }

    public long getId() {
        return id;
    }

    public Orders(long id, Integer orderNumber, float price, Integer quantity, int fkIdInventory, int fkIdSchedule) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.price = price;
        this.quantity = quantity;
        this.fkIdInventory = fkIdInventory;
        this.fkIdSchedule = fkIdSchedule;
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

    public int getFkIdInventory() {
        return fkIdInventory;
    }

    public void setFkIdInventory(int fkIdInventory) {
        this.fkIdInventory = fkIdInventory;
    }

    public int getFkIdSchedule() {
        return fkIdSchedule;
    }

    public void setFkIdSchedule(int fkIdSchedule) {
        this.fkIdSchedule = fkIdSchedule;
    }

    @Override
    public String toString() {
        return "Orders [id=" + id + ", orderNumber=" + orderNumber + ", price=" + price + ", quantity=" + quantity
                + ", fkIdInventory=" + fkIdInventory + ", fkIdSchedule=" + fkIdSchedule + "]";
    }

}
