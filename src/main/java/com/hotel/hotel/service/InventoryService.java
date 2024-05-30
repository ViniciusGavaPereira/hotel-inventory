package com.hotel.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hotel.hotel.entities.Inventory;
import com.hotel.hotel.repositories.InventoryRepository;

import exception.CustomApplicationException;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Inventory> findAll() {
        return inventoryRepository.findAll();
    }

    public Inventory findById(long id) {
        return inventoryRepository.findById(id)
                .orElseThrow(() -> new CustomApplicationException("Product not found", HttpStatus.NOT_FOUND));
    }

    public List<Inventory> findByName(String name) {

        return inventoryRepository.findByProductContaining(name);

    }

    public void createProduct(String product, int quantity, float cost) {
        Inventory inventory = new Inventory(product, quantity, cost);
        inventoryRepository.save(inventory);
    }

    public void deleteById(Long id) {

        inventoryRepository.deleteById(id);
    }

    public Inventory updateInventory(Long id, Inventory inventoryInput) {
        Inventory inventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new CustomApplicationException("Product not found", HttpStatus.NOT_FOUND));

        inventory.setProduct(inventoryInput.getProduct());
        inventory.setProduct(inventoryInput.getProduct());
        inventory.setCost(inventoryInput.getCost());

        inventoryRepository.save(inventory);

        return new Inventory();

    }

}
