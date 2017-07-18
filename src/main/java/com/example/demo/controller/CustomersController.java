package com.example.demo.controller;

import com.example.demo.domain.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HeWei on 2017/7/18.
 * .
 */
@RestController
public class CustomersController {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomersController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers/create")
    public void create() {

        List<Customer> customerList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Customer customer = new Customer();
            customer.setId(i);
            customer.setFirstName(i + "_FirstName");
            customer.setLastName(i + "_LastName");
            customer.setDescription(i + "_Description");
            customerList.add(customer);
        }

        customerRepository.insert(customerList);
    }
}
