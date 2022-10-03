package com.example.thuggeelya.services;

import com.example.thuggeelya.data.UserRepository;
import com.example.thuggeelya.data.security.LoginFormRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminService {

    private UserRepository userRepository;
    private LoginFormRepository loginFormRepository;

    @Autowired
    public AdminService(UserRepository userRepository, LoginFormRepository loginFormRepository) {
        this.userRepository = userRepository;
        this.loginFormRepository = loginFormRepository;
    }

//    public List<>
}
