package com.heritage.india.controller;

import com.heritage.india.entity.Comment;
import com.heritage.india.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/comments")
@CrossOrigin(origins = "http://localhost:5175")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/monument/{id}")
    public List<Comment> getComments(@PathVariable Long id) {
        return commentRepository.findByMonumentId(id);
    }

    @PostMapping
    public Comment addComment(@RequestBody Comment comment) {
        comment.setTimestamp(LocalDateTime.now());
        return commentRepository.save(comment);
    }
}