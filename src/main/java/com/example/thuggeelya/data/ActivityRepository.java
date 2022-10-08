package com.example.thuggeelya.data;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface ActivityRepository extends JpaRepository<Activity, Integer> {
    //    @Query("select a from Activity a where a.type.typename = :type")
    @Query("select a from Activity a where a.type.idactivitytype = 5")
    List<Activity> findCases();

    @Query("select a from Activity a where a.idactivity = :id")
    Optional<Activity> findByIdactivity(@Param("id") Integer id);

    @Query("select a from Activity a where a.status.idactivitystatus = :idactivitystatus")
    List<Activity> findAllByActivityStatusId(@Param("idactivitystatus") Integer idactivitystatus);

    List<Activity> findAllByNameContaining(@Param("name") String name);

//    @PostFilter("hasRole('ROLE_ADMIN') or #u.email == authentication.name")
//    @Query("select a from Activity a where a.status.idactivitystatus = :idactivitystatus and :user in elements(a.users)")
//    List<Activity> findAllByActivityStatusIdAndUser(Integer idactivitystatus, @P("u") @Param("user") User user);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @NotNull
    @Override
    <S extends Activity> S save(@NotNull S entity);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Modifying(clearAutomatically = true)
    @Override
    void deleteById(@Param("id") @NotNull Integer id);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Modifying(clearAutomatically = true)
    @Override
    void delete(@Param("activity") @NotNull Activity activity);
}
