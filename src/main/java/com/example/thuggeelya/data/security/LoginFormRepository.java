package com.example.thuggeelya.data.security;

import com.example.thuggeelya.data.LoginForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface LoginFormRepository extends JpaRepository<LoginForm, Integer> {
    Optional<LoginForm> findByLogin(@Param("login") String login);

    @PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ADMIN')")
    @NotNull
    List<LoginForm> findAll();

    @PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ADMIN')")
    @NotNull
    @Override
    <S extends LoginForm> S save(@NotNull S entity);

    @PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ADMIN')")
    @Modifying(clearAutomatically = true)
    @Override
    void deleteById(@Param("id") @NotNull Integer id);

    @PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ADMIN')")
    @Modifying(clearAutomatically = true)
    @Override
    void delete(@Param("loginForm") @NotNull LoginForm loginForm);
}
