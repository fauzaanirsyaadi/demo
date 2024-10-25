package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Model;
import com.example.demo.PostService;

import java.util.List;


@RestController
@RequestMapping("api/posts")
public class PostController {

    @Autowired
    private PostService postService;


    @GetMapping
    public ResponseEntity<Page<Model>> getPosts(@RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "10") int size) {
        if (page < 0 || size <= 0) {
            throw new IllegalArgumentException("Page index must be non-negative and size must be greater than zero.");
        }

        List<Model> posts = postService.getPosts();
        int start = Math.min((int) PageRequest.of(page, size).getOffset(), posts.size());
        int end = Math.min((start + size), posts.size());

        Page<Model> postPage = new PageImpl<>(posts.subList(start, end), PageRequest.of(page, size), posts.size());
        return ResponseEntity.ok(postPage);
    }

}
