package com.example.demo.persistance;

import com.example.demo.model.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getCustomers();
}
