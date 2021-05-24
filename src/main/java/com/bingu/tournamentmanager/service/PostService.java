package com.bingu.tournamentmanager.service;


import com.bingu.tournamentmanager.model.Post;

import java.util.Collection;
import java.util.List;

public interface PostService {

    public Post savePost(Post post);
    public void deletePost(Long id);
    public Post findPostById(Long id);
    public Collection<Post> findAll();
    public List<Post> findByUsername(String username);
}
