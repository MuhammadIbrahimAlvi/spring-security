package com.ecommerce.service.service;

import com.ecommerce.service.dto.UserDto;
import com.ecommerce.service.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    UserDto updateUser(Long id, User user);
    void deleteUser(Long id);
}
