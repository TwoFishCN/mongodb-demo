package com.example.demo.controller;

import com.example.demo.domain.Customer;
import com.example.demo.domain.User;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.UserRepository;
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
public class UserController {

    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public UserController(UserRepository userRepository, CustomerRepository customerRepository) {
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping("/users/create")
    public List<User> create() {

        List<Customer> customers = new ArrayList<>();
        List<User> users = new ArrayList<>();
        for (int i = 10; i <= 20; i++) {
            Customer customer = new Customer(i, i + "_FirstName", i + "_LastName", i + "_Description");
            customers.add(customer);
            User user = new User(i, i + "_name", i + "_value", customer);
            users.add(user);
        }

        customerRepository.save(customers);
        return userRepository.save(users);
    }
}
