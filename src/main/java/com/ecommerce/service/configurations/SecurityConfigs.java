package com.ecommerce.service.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfigs {

    @Bean
    public UserDetailsService userDetailsService() {

        var userDetailsManager = new InMemoryUserDetailsManager();

        var user = User.withUsername("Alvi")
                .password("123mia")
                .authorities("read")
                .build();

        userDetailsManager.createUser(user);

        return userDetailsManager;

    }

    @Bean
    public PasswordEncoder bCryptPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
