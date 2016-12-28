package com.lugowski.dao;

import com.lugowski.entities.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByNameAndSurnameAndEmail(String name, String surname, String email);
}
