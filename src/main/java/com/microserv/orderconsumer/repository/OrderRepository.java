package com.microserv.orderconsumer.repository;

import com.microserv.orderconsumer.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
