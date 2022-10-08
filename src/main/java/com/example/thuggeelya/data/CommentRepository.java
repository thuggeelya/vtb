package com.example.thuggeelya.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Modifying(clearAutomatically = true)
    @Query("update Comment c set c.nlikes = nlikes + 1 where c.idcomment = :idcomment")
    void like(@Param("idcomment") Integer idcomment);

    List<Comment> findAllByTextContaining(@Param("text") String text);

    List<Comment> findTop2ByOrderByNlikesDesc();
}