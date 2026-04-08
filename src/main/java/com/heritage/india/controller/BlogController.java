package com.heritage.india.controller;

import com.heritage.india.entity.Blog;
import com.heritage.india.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5175") 
@RestController

@RequestMapping("/api/blogs")
// Replace 5173 with your actual React port if it's different
//@CrossOrigin(origins = "http://localhost:5173") 
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    // GET all blogs for the Blog.jsx page
    @GetMapping
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    // GET a single blog by ID (useful for the "Read More" feature)
    @GetMapping("/{id}")
    public Blog getBlogById(@PathVariable Long id) {
        return blogRepository.findById(id).orElse(null);
    }
}