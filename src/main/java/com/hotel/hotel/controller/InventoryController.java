package com.hotel.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Inventory result = inventoryService.findById(id);
        System.out.println(result);
        return new ResponseEntity<Inventory>(result, HttpStatus.OK);

    }

    @GetMapping("/product/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name) {
        List<Inventory> result = inventoryService.findByName(name);
        System.out.println(result);
        return new ResponseEntity<List<Inventory>>(result, HttpStatus.OK);

    }
}
