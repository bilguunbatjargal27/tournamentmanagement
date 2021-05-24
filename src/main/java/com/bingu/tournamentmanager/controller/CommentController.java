package com.bingu.tournamentmanager.controller;

import com.bingu.tournamentmanager.model.Comment;
import com.bingu.tournamentmanager.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("comment")
@CrossOrigin(origins = "*")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("")
    public ResponseEntity<?> getAllComments() {
        List<Comment> Comments = (List<Comment>) commentService.findAll();
        return ResponseEntity.ok(Comments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCommentById(@PathVariable("id") Long id) {
        Comment Comment = commentService.findCommentById(id);
        return ResponseEntity.ok(Comment);
    }

    @GetMapping("/user/{commentId}")
    public ResponseEntity<?> getCommentByUsername(@PathVariable("commentId") Long id) {
        List<Comment> comment = commentService.findByPostId(id);
        return ResponseEntity.ok(comment);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addComment(@RequestBody final Comment comment) {
        comment.setCreateDate(new Date());
        Comment responseComment = commentService.saveComment(comment);
        return ResponseEntity.ok(responseComment);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateComment(@RequestBody final Comment updatedComment) {
        updatedComment.setUpdateDate(new Date());
        Comment responseComment = commentService.saveComment(updatedComment);
        return ResponseEntity.ok(responseComment);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable("id") Long id) {
        Comment comment = commentService.findCommentById(id);
        if(comment == null) return ResponseEntity.badRequest().body("No comment exist with given ID = " + id);
        if(comment.getReplay() == null){
            List<Comment> replays = commentService.findByReplayId(comment.getId());
            for(Comment replay: replays){
                commentService.deleteComment(replay.getId());
            }
        }
        commentService.deleteComment(id);
        return ResponseEntity.ok("Successfully deleted");
    }
}
