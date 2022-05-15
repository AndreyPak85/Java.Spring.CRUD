package com.ap.blog.controller;

import com.ap.blog.entity.BlogEntity;
import com.ap.blog.exceptions.BlogAlreadyExistException;
import com.ap.blog.exceptions.BlogNotFound;
import com.ap.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

//    @GetMapping
//    public Iterable<BlogEntity> getBlogs() {
//        try {
//            return blogService.getBlogs();
//        }
//        catch (Exception e) {
//            return (Iterable<BlogEntity>) ResponseEntity.badRequest().body("Internal error");
//        }
//    }

    @GetMapping
    public ResponseEntity getDetailBlog(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(blogService.getDetailBlog(id));
        }
            catch (BlogNotFound e) {
                return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Internal error");

        }
    }

    @PostMapping
    public ResponseEntity addBlog(@RequestBody BlogEntity blog)  {
        try {
            blogService.saveBlog(blog);
            return ResponseEntity.ok("Blog save");
        }
        catch (BlogAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().body("Internal error");

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBlog(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(blogService.deleteBlog(id));
        }

        catch (Exception e) {
            return ResponseEntity.badRequest().body("Internal error");

        }
    }

}
