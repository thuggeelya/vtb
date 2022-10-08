package com.example.thuggeelya.data.security;

import com.example.thuggeelya.data.LoginForm;
import com.example.thuggeelya.data.Role;
import com.example.thuggeelya.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class LoginFormService implements UserDetailsService {

    private final LoginFormRepository repository;
    private final UserRepository userRepository;

    @Autowired
    public LoginFormService(LoginFormRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public List<LoginForm> getAll() {
        return this.repository.findAll();
    }

    public LoginForm getByLogin(String login) {
        return this.repository.findByUsername(login).orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        LoginForm loginForm = getByLogin(login);

        if (Objects.isNull(loginForm)) {
            throw new UsernameNotFoundException(String.format("User %s is not found", login));
        }

        return new User(loginForm.getUsername(), loginForm.getPassword(), true, true,
                true, true,
                getAuthorities(new HashSet<>()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
        return roles
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}