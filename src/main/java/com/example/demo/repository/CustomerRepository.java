package com.example.demo.repository;

import com.example.demo.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by HeWei on 2017/7/18.
 * .
 */
public interface CustomerRepository extends MongoRepository<Customer, Integer> {
}
