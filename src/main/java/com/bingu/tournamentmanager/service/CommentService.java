package com.bingu.tournamentmanager.service;


import com.bingu.tournamentmanager.model.Comment;

import java.util.Collection;
import java.util.List;

public interface CommentService {

    Comment saveComment(Comment comment);
    void deleteComment(Long id);
    Comment findCommentById(Long id);
    Collection<Comment> findAll();
    List<Comment> findByPostId(Long id);
    List<Comment> findByReplayId(Long id);
}
