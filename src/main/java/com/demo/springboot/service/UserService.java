package com.demo.springboot.service;

import com.demo.springboot.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(User userRegistrationDto);
}
