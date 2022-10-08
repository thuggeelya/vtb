package com.example.thuggeelya.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserlevelRepository extends JpaRepository<Userlevel, Integer> {
    @Modifying(clearAutomatically = true)
    @Query("update Userlevel u set u.nlevel = nlevel + 1 where u.iduser = :iduser")
    void incLevel(@Param("iduser") Integer iduser);

    @Modifying(clearAutomatically = true)
    @Query("update Userlevel u set u.exp = exp + :exp where u.iduser = :iduser")
    void incExp(@Param("exp") Integer exp, @Param("iduser") Integer iduser);
}