package com.hotel.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hotel.hotel.service.InventoryService;
import exception.CustomApplicationException;
import com.hotel.hotel.dto.InventoryDto;
import com.hotel.hotel.entities.Inventory;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
@RestController
@RequestMapping(value = "/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping(value = "/all")
    public List<InventoryDto> findAll() {

        List<Inventory> result = inventoryService.findAll();
        return InventoryDto.inventoryConverter(result);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<InventoryDto> findById(@PathVariable Long id) {
        Inventory result = inventoryService.findById(id);

        return new ResponseEntity<InventoryDto>(new InventoryDto(result), HttpStatus.OK);

    }

    @GetMapping(value = "/product/{name}")
    public ResponseEntity<List<InventoryDto>> findByName(@PathVariable String name) {
        List<Inventory> result = inventoryService.findByName(name);

        return new ResponseEntity<List<InventoryDto>>(InventoryDto.inventoryConverter(result), HttpStatus.OK);

    }

    @PostMapping(value = "/createproduct/v1/")
    public ResponseEntity<?> createProduct(@RequestBody Inventory inventoryInput) {

        Inventory inventory = new Inventory(inventoryInput.getProduct(), inventoryInput.getQuantity(),
                inventoryInput.getCost());

        inventoryService.createProduct(inventory.getProduct(), inventory.getQuantity(), inventory.getCost());
        return new ResponseEntity<>("Product was ceated successffully:\n" + new InventoryDto(inventory).toString(),
                HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        inventoryService.deleteById(id);
        return new ResponseEntity<>("Product was deleted", HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryDto> updateProduct(@PathVariable long id, @RequestBody Inventory inventory) {

        try {
            inventoryService.updateInventory(id, inventory);
            return new ResponseEntity<InventoryDto>(new InventoryDto(inventory), HttpStatus.OK);

        } catch (EmptyResultDataAccessException e) {
            throw new CustomApplicationException("Product not found", HttpStatus.NOT_FOUND);

        }
    }

}
