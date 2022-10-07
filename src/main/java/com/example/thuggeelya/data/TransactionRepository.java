package com.example.thuggeelya.data;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RepositoryRestResource
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    List<Transaction> findAllBySender_Iduser(@Param("iduser") Integer iduser);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    @NotNull
    List<Transaction> findAll();

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Modifying(clearAutomatically = true)
    @Override
    void delete(@NotNull Transaction entity);
}