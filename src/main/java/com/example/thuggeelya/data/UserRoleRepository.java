package com.example.thuggeelya.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
}