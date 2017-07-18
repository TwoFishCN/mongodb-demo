package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by HeWei on 2017/7/18.
 * .
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User {

    @Id
    public Integer id;

    public String name;

    public String value;

    @DBRef
    @Field
    public Customer customer;
}
