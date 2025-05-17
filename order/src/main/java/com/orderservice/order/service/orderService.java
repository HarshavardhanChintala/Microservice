package com.orderservice.order.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.orderservice.order.OrderApplication;
import com.orderservice.order.model.Order;
import com.orderservice.order.repository.orderRepository;

@Service
public class orderService {

    private final OrderApplication orderApplication;
    
    private final orderRepository repo;

    @Autowired
    public orderService(orderRepository repo, OrderApplication orderApplication) {
        this.repo = repo;
        this.orderApplication = orderApplication;
    }

    public Order save(Order order) {
        order.setDate(LocalDate.now().toString());
        return repo.save(order);
    }

    public Order findById(int id) {
        return repo.findById(id).orElse(null);
    }

    public List<Order> findAll() {
        return repo.findAll();
    }

    public Order updateOrderById(int id, Order updatedOrder) {
        return repo.findById(id).map(order -> {
            order.setCustomerId(updatedOrder.getCustomerId());
            order.setQuantity(updatedOrder.getQuantity());
            order.setDate(LocalDate.now().toString());
            order.setProduct(updatedOrder.getProduct());
            return repo.save(order);
        }).orElse(null); 
    }

    public String deleteOrderByID(int id){
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Success: Order deleted!";
        } else {
            return "Error: Order not found!";
        }
    }
}
