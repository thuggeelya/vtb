package com.example.thuggeelya.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Integer> {
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    List<User> findByBalanceIs(@Param("balance") Integer balance);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    List<User> findByBalanceBetweenOrderByBalanceDesc(Integer balanceStart, Integer balanceEnd);

    Optional<User> findByIduser(@Param("iduser") Integer iduser);

    @PreAuthorize("hasRole('ROLE_MANAGER') || hasRole('ROLE_HR') || hasRole('ROLE_ADMIN')")
    @Modifying(clearAutomatically = true)
    @Query("update User u set u.balance = :balance where u.iduser = :id")
    int updateUserBalance(@Param("balance") Integer balance, @Param("id") Integer id);

    @Modifying(clearAutomatically = true)
    @Query("update User u set u.datebalancing = CURRENT_DATE where u.datebalancing is null")
    void upToDateUsersBalanceDateIfNull();

    @Modifying(clearAutomatically = true)
    @Query("update User u set u.idwalet = :idwalet where u.iduser = :iduser")
    void setWaletById(@Param("iduser") Integer iduser, @Param("idwalet") Integer idwalet);
}
