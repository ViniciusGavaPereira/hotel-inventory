package com.hotel.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hotel.hotel.entities.Orders;
import com.hotel.hotel.repositories.OrdersRepository;

import exception.CustomApplicationException;
import exception.CustomApplicationException.EmptyListException;
import jakarta.transaction.Transactional;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

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
        return ordersRepository.save(orders);
    }

    public void deleteById(Long id) {

        ordersRepository.deleteById(id);
    }

    @Transactional
    public void deleteByOrderNumber(Integer orderNumber) {
        ordersRepository.deleteByOrderNumber(orderNumber);
    }

}
