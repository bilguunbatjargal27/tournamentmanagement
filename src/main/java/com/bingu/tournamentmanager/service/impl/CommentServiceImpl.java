package com.bingu.tournamentmanager.service.impl;

import com.bingu.tournamentmanager.model.Comment;
import com.bingu.tournamentmanager.repository.CommentRepository;
import com.bingu.tournamentmanager.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Comment findCommentById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public Collection<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> findByPostId(Long id) {
        return commentRepository.findByPostId(id);
    }

    @Override
    public List<Comment> findByReplayId(Long id) {
        return commentRepository.findByReplay(id);
    }
}
