package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.entity.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerDAO customerDAO;

    @Autowired
    public CustomerServiceImpl(CustomerDAO customerDAO){
        this.customerDAO = customerDAO;
    }

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int customerId) {
        return customerDAO.getCustomer(customerId);
    }

    @Override
    @Transactional
    public void deleteCustomer(int customerId) {
        customerDAO.deleteCustomer(customerId);
    }

    @Override
    @Transactional
    public List<Customer> searchCustomers(String searchName) {
        return customerDAO.searchCustomers(searchName);
    }
}
