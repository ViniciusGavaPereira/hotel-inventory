package com.hotel.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel.entities.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}
