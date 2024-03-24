package com.ecommerce.service.configurations;

import com.ecommerce.service.entity.User;
import com.ecommerce.service.repository.UserRepository;
import com.ecommerce.service.securityclasses.UserPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByFullName(username).orElseThrow(()-> new UsernameNotFoundException("User not Found"));
        return new UserPrincipal(user);
    }
}
