package com.hotel.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hotel.hotel.dto.ScheduleDto;
import com.hotel.hotel.entities.Orders;
import com.hotel.hotel.http.ScheduleClient;
import com.hotel.hotel.repositories.OrdersRepository;

import exception.CustomApplicationException;
import exception.CustomApplicationException.EmptyListException;
import jakarta.transaction.Transactional;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private ScheduleClient scheduleClient;

    @Autowired
    private InventoryService inventoryService;

    public ScheduleDto findSchedule(Integer id) {
        ScheduleDto schedule = scheduleClient.findById(id);
        return schedule;
    }

    public List<Orders> findAll() {
        return ordersRepository.findAll();
    }

    public Orders findById(Long id) {
        return ordersRepository.findById(id)
                .orElseThrow(() -> new CustomApplicationException("Id not found", HttpStatus.NOT_FOUND));
    }

    public List<Orders> findByOrderNumber(Integer orderNumber) {

        try {
            return ordersRepository.findByOrderNumber(orderNumber);

        } catch (EmptyListException e) {
            throw new CustomApplicationException("Order not found", HttpStatus.NOT_FOUND);
        }

    }

    public Orders createOrder(Orders orders) {

        // Connect to Schedule's endpoint
        findSchedule(orders.getFkIdSchedule());

        // Verify if the endpoint exist's
        inventoryService.findById(orders.getFkIdInventory());

        return ordersRepository.save(orders);
    }

    @Transactional
    public Orders updateOrder(long id, Orders orderInput) {
        Orders orders = ordersRepository.findById(id)
                .orElseThrow(() -> new CustomApplicationException("Order not found",
                        HttpStatus.NOT_FOUND));

        // Connect to Schedule's endpoint
        findSchedule(orderInput.getFkIdSchedule());

        // Verify if the endpoint exist's
        inventoryService.findById(orderInput.getFkIdInventory());

        orders.setId(orderInput.getId());
        orders.setPrice(orderInput.getPrice());
        orders.setQuantity(orderInput.getQuantity());
        orders.setFkIdInventory(orderInput.getFkIdInventory());
        orders.setFkIdSchedule(orderInput.getFkIdSchedule());
        orders.setOrderNumber(orderInput.getOrderNumber());
        ordersRepository.save(orders);

        return orders;
    }

    public void deleteById(Long id) {

        ordersRepository.deleteById(id);
    }

    @Transactional
    public void deleteByOrderNumber(Integer orderNumber) {
        ordersRepository.deleteByOrderNumber(orderNumber);
    }
}
