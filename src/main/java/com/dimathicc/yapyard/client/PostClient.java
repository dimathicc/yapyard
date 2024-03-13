package com.dimathicc.yapyard.client;

import com.dimathicc.yapyard.dto.PostDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "postClient", url = "https://jsonplaceholder.typicode.com/posts")
public interface PostClient {

    @GetMapping
    List<PostDTO> listPosts();

    @GetMapping("/{postId}")
    PostDTO postById(@PathVariable Long postId);

    @PostMapping
    PostDTO createPost(@RequestBody PostDTO postDTO);

    @PutMapping("/{postId}")
    PostDTO updatePost(@PathVariable Long postId, @RequestBody PostDTO postDTO);

    @DeleteMapping("/{postId}")
    PostDTO deletePost(@PathVariable Long postId);

}
