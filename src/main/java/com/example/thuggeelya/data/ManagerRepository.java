package com.example.thuggeelya.data;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @NotNull
    @Override
    <S extends Manager> S save(@NotNull S entity);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    void deleteById(@Param("id") @NotNull Integer id);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    void delete(@Param("manager") @NotNull Manager manager);
}
