package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.persistance.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {


    private CustomerDAO customerDAO;

    @Autowired
    public CustomerController(CustomerDAO customerDAO){
        this.customerDAO = customerDAO;
    }

    @RequestMapping("/list")
    public String listCustomers(Model model){

        List<Customer> customerList = customerDAO.getCustomers();

        model.addAttribute("customers", customerList);

        return "list-customers";
    }
}
