package com.ecommerce.service.service;

import com.ecommerce.service.dto.UserDto;
import com.ecommerce.service.entity.User;
import com.ecommerce.service.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired private UserRepository userRepository;

    @Override
    public User createUser(User customer) {
        return userRepository.save(customer);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional
    public UserDto updateUser(Long id, User customer) {
        User customer1 = userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User not Found"));

        customer1.setEmail(customer.getEmail());
        customer1.setFullName(customer.getFullName());
        customer1.setCountry(customer.getCountry());
        customer1.setPassword(customer.getPassword());

        customer1 = userRepository.save(customer1);

        return new UserDto(customer1.getFullName(), customer1.getEmail(), customer1.getCountry());
    }

    @Override
    public void deleteUser(Long id) {
        User customer = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not Found"));
        userRepository.delete(customer);
    }

}
