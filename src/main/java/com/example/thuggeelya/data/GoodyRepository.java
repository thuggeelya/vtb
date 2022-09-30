package com.example.thuggeelya.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface GoodyRepository extends JpaRepository<Goody, Integer> {
    Collection<Goody> findByName(@Param("name") String name);
}
