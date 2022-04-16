package com.rentcloud.profileservice.service;

import com.rentcloud.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer save(Customer customer);

    Customer fetchById(int id);

    List<Customer> fetchAll();
}
