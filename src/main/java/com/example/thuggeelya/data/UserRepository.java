package com.example.thuggeelya.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Integer> {
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    List<User> findByBalanceIs(@Param("balance") Integer balance);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    List<User> findByBalanceBetweenOrderByBalanceDesc(Integer balanceStart, Integer balanceEnd);
}
