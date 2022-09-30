package com.example.thuggeelya.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface ActivityRepository extends JpaRepository<Activity, Integer> {
    Collection<Activity> findByName(@Param("name") String name);
    @Query("select a from Activity a where a.type.typename = :type")
    Collection<Activity> findAllByActivityTypeName(@Param("type") String type);
    @Query("select a from Activity a where a.status.statusname = :status")
    Collection<Activity> findAllByActivityStatusName(@Param("status") String status);
}
