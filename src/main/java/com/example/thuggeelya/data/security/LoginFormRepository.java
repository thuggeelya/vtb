package com.example.thuggeelya.data.security;

import com.example.thuggeelya.data.LoginForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface LoginFormRepository extends JpaRepository<LoginForm, Integer> {
    LoginForm findByLogin(@Param("login") String login);
}
