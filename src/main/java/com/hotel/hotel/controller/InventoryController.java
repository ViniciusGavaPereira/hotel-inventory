package com.hotel.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotel.service.InventoryService;
import com.hotel.hotel.entities.Inventory;

@Controller
@RestController
@RequestMapping(value = "/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/all")
    public List<Inventory> findAll() {
        return inventoryService.findAll();
    }

}
