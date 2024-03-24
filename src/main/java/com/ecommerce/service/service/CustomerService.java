package com.ecommerce.service.service;

import com.ecommerce.service.dto.CustomerDto;
import com.ecommerce.service.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Optional<Customer> getCustomerById(Long id);
    CustomerDto updateCustomer(Long id, Customer customer);
    void deleteCustomer(Long id);
}
