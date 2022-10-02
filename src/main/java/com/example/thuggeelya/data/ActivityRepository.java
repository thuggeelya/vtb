package com.example.thuggeelya.data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ActivityRepository extends JpaRepository<Activity, Integer> {
    List<Activity> findByNameContaining(@Param("name") String name);

    @Query("select a from Activity a where a.type.typename = :type")
    Page<Activity> findAllByActivityTypeName(@Param("type") String type, Pageable nextPage);

    @Query("select a from Activity a where a.status.idactivitystatus = :idactivitystatus")
    Page<Activity> findAllByActivityStatusId(@Param("idactivitystatus") Integer idactivitystatus, Pageable nextPage);

    Page<Activity> findByNameContaining(@Param("name") String name, Pageable nextPage);
}
