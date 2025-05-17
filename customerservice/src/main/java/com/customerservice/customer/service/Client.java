package com.customerservice.customer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.customerservice.customer.model.Order;

@FeignClient(name = "order")
public interface Client {
    @GetMapping("/api/orders/{id}")
    Order orderById(@PathVariable int id);
}
