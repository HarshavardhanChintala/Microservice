package com.orderservice.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderservice.order.model.Order;
import com.orderservice.order.service.orderService;

@RestController
@RequestMapping("/api/orders")
public class orderController {
    
    private final orderService service;
    
    @Autowired
    public orderController(orderService service) {
        this.service = service;
    }

    @PostMapping
    public Order createOrder(@RequestBody Order input) {
        return service.save(input);
    }

    @GetMapping("/{id}")
    public Order orderById(@PathVariable int id) {
        return service.findById(id);
    }

    @GetMapping()
    public List<Order> listOrders() {
        return service.findAll();
    }

    @PutMapping("/{id}")
    public String updateOrderById(@PathVariable int id, @RequestBody Order order) {
        service.updateOrderById(id, order);
        return "Sucess";
    }

    @DeleteMapping("/{id}")
    public String deleteOrderById(@PathVariable int id) {
        return service.deleteOrderByID(id);
    }
}
