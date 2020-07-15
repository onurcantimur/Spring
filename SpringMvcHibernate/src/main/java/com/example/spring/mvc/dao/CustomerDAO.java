package com.example.spring.mvc.dao;

import com.example.spring.mvc.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();

    Customer getCustomer(int id);

    void addCustomer(Customer customer);

    void deleteCustomer(int id);
}
