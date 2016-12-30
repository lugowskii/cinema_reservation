package com.lugowski.service;

import com.lugowski.dao.CustomerRepository;
import com.lugowski.entities.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public Customer findIdByCustomer(Customer customer) {
        return customerRepository.
                findByNameAndSurnameAndEmail(customer.getName(), customer.getSurname(), customer.getEmail())
                .stream()
                .findFirst()
                .orElse(null);
    }
}
