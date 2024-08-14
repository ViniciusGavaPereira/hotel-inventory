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

import com.hotel.hotel.dto.OrdersDto;
import com.hotel.hotel.entities.Orders;
import com.hotel.hotel.service.OrdersService;

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

}
