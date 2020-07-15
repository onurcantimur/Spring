package com.example.spring.mvc.service;

import com.example.spring.mvc.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    void addCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);
}
