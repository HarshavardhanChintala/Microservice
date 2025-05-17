package com.orderservice.order.repository;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderservice.order.model.Order;

@Repository
public interface orderRepository extends JpaRepository<Order,Integer>{

}
