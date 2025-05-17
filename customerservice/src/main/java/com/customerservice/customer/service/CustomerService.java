package com.customerservice.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customerservice.customer.model.Customer;
import com.customerservice.customer.model.Order;
import com.customerservice.customer.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository repo;
    private final Client client;
    @Autowired
    public CustomerService(CustomerRepository repo, Client client) {
        this.repo = repo;
        this.client = client;
    }

    public List<Customer> listAllCustomers() {
        return repo.findAll();
    }

    public Customer findCustomerById(int id) {
        return repo.findById(id).get();
    }

    public Customer createCustomer(Customer customer) {
        return repo.save(customer);
    }

    public Customer updateCustomerById(int id, Customer updatedCustomer) {
        return repo.findById(id).map(customer-> {
            customer.setAddress(updatedCustomer.getAddress());
            customer.setEmail(updatedCustomer.getEmail());
            customer.setFirstName(updatedCustomer.getFirstName());
            customer.setLastName(updatedCustomer.getLastName());
            customer.setPhoneNumber(updatedCustomer.getPhoneNumber());
            return repo.save(customer);
        }).orElse(null);
    }

    public Order findOrdersForCustomerById(int id) {
       return client.orderById(id);
    }
}
