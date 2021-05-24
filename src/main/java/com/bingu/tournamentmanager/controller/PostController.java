package com.bingu.tournamentmanager.controller;

import com.bingu.tournamentmanager.model.Category;
import com.bingu.tournamentmanager.model.Post;
import com.bingu.tournamentmanager.model.Tag;
import com.bingu.tournamentmanager.service.CategoryService;
import com.bingu.tournamentmanager.service.PostService;
import com.bingu.tournamentmanager.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("post")
@CrossOrigin(origins = "*")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private TagService tagService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<?> getAllPosts() {
        List<Post> Posts = (List<Post>) postService.findAll();
        return ResponseEntity.ok(Posts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPostById(@PathVariable("id") Long id) {
        Post Post = postService.findPostById(id);
        return ResponseEntity.ok(Post);
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<?> getPostByUsername(@PathVariable("username") String username) {
        List<Post> post = postService.findByUsername(username);
        return ResponseEntity.ok(post);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addPost(@RequestBody final Post post) {
        post.setCreateDate(new Date());
//        List<String> tags = Arrays.stream(" ".split(post.getContent())).filter(s -> s.startsWith("#")).collect(Collectors.toList());
        List<String> tags = Arrays.stream(post.getContent().split(" ")).filter( s -> s.startsWith("#")).collect(Collectors.toList());
        if (tags.size() > 0) {
            List<Tag> tagList = new ArrayList<>();
            for (String tag : tags) {
                System.out.println(tag);
                tagList.add(new Tag(tag));
            }
            tagService.saveTags(tagList);
        }
        if(post.getCategories().size() > 0){
            for(Category category : post.getCategories()){
                categoryService.saveCategory(category);
            }
        }
        Post responsePost = postService.savePost(post);
        return ResponseEntity.ok(responsePost);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updatePost(@RequestBody final Post updatedPost) {
        updatedPost.setUpdateDate(new Date());
        Post responsePost = postService.savePost(updatedPost);
        return ResponseEntity.ok(responsePost);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePost(@PathVariable("id") Long id) {
        Post post = postService.findPostById(id);
        if (post == null) return ResponseEntity.badRequest().body("No post exist with given ID = " + id);
//        List<Comment> postCommends = post.getComments();
//        for(Comment comment: postCommends){
//            commentService.deleteComment(comment.getId());
//        }
        postService.deletePost(id);
        return ResponseEntity.ok("Successfully deleted");
    }
}
