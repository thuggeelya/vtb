package com.example.thuggeelya.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findAllByTextContaining(@Param("text") String text);

    List<Comment> findTop3ByOrderByNlikesDesc();
}