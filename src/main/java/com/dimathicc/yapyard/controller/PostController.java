package com.dimathicc.yapyard.controller;

import com.dimathicc.yapyard.client.PostClient;
import com.dimathicc.yapyard.dto.PostDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostClient postClient;

    @GetMapping
    public ResponseEntity<List<PostDTO>> listPosts() {
        return ResponseEntity.ok(postClient.listPosts());
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDTO> postById(@PathVariable Long postId) {
        return ResponseEntity.ok(postClient.postById(postId));
    }

    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postClient.createPost(postDTO));
    }

    @PutMapping("/{postId}")
    public ResponseEntity<PostDTO> updatePost(@PathVariable Long postId, @RequestBody PostDTO postDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(postClient.updatePost(postId, postDTO));
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<PostDTO> deletePost(@PathVariable Long postId) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(postClient.deletePost(postId));
    }

}
