package com.hotel.hotel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.hotel.entities.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

    List<Orders> findByOrderNumber(Integer orderNumber);

    void deleteByOrderNumber(Integer orderNumber);

}
