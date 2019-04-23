package com.example.demo.controller;

import com.example.demo.domain.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * Created by HeWei on 2017/7/18.
 * .
 */
@RestController
@RequestMapping(value = "/customers")
public class CustomersController {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomersController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Customer customer) {
        if (customer != null) {
            customerRepository.delete(customer);
        }
    }

    @PutMapping("/{id}")
    public Customer update(Customer customer, @PathVariable Integer id) {
        Customer customerOld = customerRepository.findOne(id);
        customerOld.setFirstName(customer.getFirstName());
        return customerRepository.save(customerOld);
    }

    @GetMapping
    public Page<Customer> index(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Customer show(@PathVariable(name = "id") Customer customer) {
        return customer;
    }

    @PostMapping("/search")
    public Page<Customer> search(@RequestBody Customer example, Pageable pageable) {
        return customerRepository.findAll(Example.of(example), pageable);
    }
}
