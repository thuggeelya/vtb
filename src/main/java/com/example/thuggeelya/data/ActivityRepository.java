package com.example.thuggeelya.data;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RepositoryRestResource
public interface ActivityRepository extends JpaRepository<Activity, Integer> {
    List<Activity> findAllByNameContaining(@Param("name") String name);

    @Query("select a from Activity a where a.type.typename = :type")
    List<Activity> findAllByActivityTypeName(@Param("type") String type);

    @Query("select a from Activity a where a.status.idactivitystatus = :idactivitystatus")
    List<Activity> findAllByActivityStatusId(@Param("idactivitystatus") Integer idactivitystatus);

    List<Activity> findByNameContaining(@Param("name") String name);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @NotNull
    @Override
    <S extends Activity> S save(@NotNull S entity);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    void deleteById(@Param("id") @NotNull Integer id);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    void delete(@Param("activity") @NotNull Activity activity);
}
