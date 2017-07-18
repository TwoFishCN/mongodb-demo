package com.example.demo.repository;

import com.example.demo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by HeWei on 2017/7/18.
 * .
 */
public interface UserRepository extends MongoRepository<User, Integer> {
}
