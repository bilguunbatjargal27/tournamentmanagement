package com.bingu.tournamentmanager.repository;
import com.bingu.tournamentmanager.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByUserUsername(String username);
}
