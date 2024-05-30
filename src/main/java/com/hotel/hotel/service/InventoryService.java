package com.hotel.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.hotel.entities.Inventory;
import com.hotel.hotel.repositories.InventoryRepository;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Inventory> findAll() {
        return inventoryRepository.findAll();
    }

    public Inventory findById(long id) {
        return inventoryRepository.findById(id).get();
    }

    public List<Inventory> findByName(String name) {

        return inventoryRepository.findByProductContaining(name);

    }

    public void createProduct(String product, int quantity, float cost) {
        Inventory inventory = new Inventory(product, quantity, cost);
        inventoryRepository.save(inventory);
    }

}
