package com.example.thuggeelya.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Integer> {
    Collection<User> findByIduser(@Param("id") Integer id);
}
