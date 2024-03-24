package com.ecommerce.service.service;

import com.ecommerce.service.dto.CustomerDto;
import com.ecommerce.service.entity.Customer;
import com.ecommerce.service.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    @Transactional
    public CustomerDto updateCustomer(Long id, Customer customer) {
        Customer customer1 = customerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Customer not Found"));

        customer1.setEmail(customer.getEmail());
        customer1.setFullName(customer.getFullName());
        customer1.setCountry(customer.getCountry());
        customer1.setPassword(customer.getPassword());

        customer1 = customerRepository.save(customer1);

        return new CustomerDto(customer1.getFullName(), customer1.getEmail(), customer1.getCountry());
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(()-> new RuntimeException("Customer not Found"));
        customerRepository.delete(customer);
    }

}
