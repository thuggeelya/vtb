package com.example.thuggeelya.data.security;

import com.example.thuggeelya.data.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@Service
public class LoginFormService implements UserDetailsService {

    private final LoginFormRepository repository;

    @Autowired
    public LoginFormService(LoginFormRepository repository) {
        this.repository = repository;
    }

    public List<LoginForm> getAll() {
        return this.repository.findAll();
    }

    public LoginForm getByLogin(String login) {
        return this.repository.findByLogin(login);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        LoginForm loginForm = getByLogin(login);
        if (Objects.isNull(loginForm)) {
            throw new UsernameNotFoundException(String.format("User %s is not found", login));
        }
        return new User(loginForm.getLogin(), loginForm.getPassword(), true, true,
                true, true, new HashSet<>());
    }
}