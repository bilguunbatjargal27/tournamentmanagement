package com.bingu.tournamentmanager.repository;

import com.bingu.tournamentmanager.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByPostId(Long id);
    List<Comment> findByReplay(Long id);
}
