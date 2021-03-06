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

    private void save(Customer customer) {
        customerRepository.save(customer);
    }

    private Customer findIdByCustomer(Customer customer) {
        return customerRepository.
                findByNameAndSurnameAndEmail(customer.getName(), customer.getSurname(), customer.getEmail())
                .stream()
                .findFirst()
                .orElse(null);
    }

    public Customer saveCustomer(Customer customer) {
        Customer toAdd = new Customer(customer.getName(), customer.getSurname(), customer.getEmail());
        save(toAdd);
        return findIdByCustomer(toAdd);
    }
}
