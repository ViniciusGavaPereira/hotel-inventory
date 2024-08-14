package com.hotel.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.hotel.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
