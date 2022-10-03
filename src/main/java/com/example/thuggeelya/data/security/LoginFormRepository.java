package com.example.thuggeelya.data.security;

import com.example.thuggeelya.data.LoginForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.Optional;

public interface LoginFormRepository extends JpaRepository<LoginForm, Integer> {
    Optional<LoginForm> findByLogin(@Param("login") String login);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @NotNull List<LoginForm> findAll();
}
