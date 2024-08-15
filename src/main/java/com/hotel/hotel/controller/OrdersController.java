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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotel.dto.OrdersDto;
import com.hotel.hotel.entities.Orders;
import com.hotel.hotel.service.OrdersService;

import exception.CustomApplicationException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RestController
@RequestMapping(value = "/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping(value = "/all")
    public List<OrdersDto> findAll() {

        List<Orders> result = ordersService.findAll();
        return OrdersDto.ordersConverter(result);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrdersDto> findById(@PathVariable Long id) {
        Orders result = ordersService.findById(id);

        return new ResponseEntity<OrdersDto>(new OrdersDto(result), HttpStatus.OK);

    }

    @GetMapping(value = "/orderNumber/{orderNumber}")
    public ResponseEntity<List<OrdersDto>> findByOrderNumber(@PathVariable Integer orderNumber) {
        List<Orders> result = ordersService.findByOrderNumber(orderNumber);

        return new ResponseEntity<List<OrdersDto>>(OrdersDto.ordersConverter(result), HttpStatus.OK);

    }

    @PostMapping("/save/")
    public ResponseEntity<?> createOrder(@RequestBody Orders orders) {
        Orders order = ordersService.createOrder(orders);

        return new ResponseEntity<>("Order was ceated successffully:\n" + new OrdersDto(order).toString(),
                HttpStatus.CREATED);
    }

    /*
     * @PutMapping("/{id}")
     * public ResponseEntity<OrdersDto> updateProduct(@PathVariable long
     * id, @RequestBody Orders order) {
     * 
     * try {
     * ordersService.updateOrder(id, order);
     * return new ResponseEntity<OrdersDto>(new OrdersDto(order), HttpStatus.OK);
     * 
     * } catch (EmptyResultDataAccessException e) {
     * throw new CustomApplicationException("Order not found",
     * HttpStatus.NOT_FOUND);
     * 
     * }
     * }
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        ordersService.deleteById(id);
        return new ResponseEntity<>("Order with id " + id + " was deleted", HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/deleteByOrderNumber/{orderNumber}")
    public ResponseEntity<?> deleteByOrderNumber(@PathVariable Integer orderNumber) {
        ordersService.deleteByOrderNumber(orderNumber);
        return new ResponseEntity<>("Order with number " + orderNumber + " was deleted", HttpStatus.ACCEPTED);
    }

}
