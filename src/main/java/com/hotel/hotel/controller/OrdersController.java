package com.hotel.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
}
