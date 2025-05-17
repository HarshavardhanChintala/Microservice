package com.customerservice.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customerservice.customer.model.Customer;
import com.customerservice.customer.model.Order;
import com.customerservice.customer.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class Cotroller {
    private final CustomerService service;

    @Autowired
    public Cotroller(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Customer> listAllCustomers() {
        return service.listAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer findCustomer(@PathVariable int id) {
        return service.findCustomerById(id);
    }

    @GetMapping("/{id}/orders")
    public Order findAllOrderforCustomerById(@PathVariable int id) {
        return service.findOrdersForCustomerById(id);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return service.createCustomer(customer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomerById(@PathVariable int id, @RequestBody Customer customer) {
        return service.updateCustomerById(id, customer);
    }
}
