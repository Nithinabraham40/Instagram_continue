package com.geekster.InstagramProject.controller;

import com.geekster.InstagramProject.model.Post;
import com.geekster.InstagramProject.service.PostService;
import com.geekster.InstagramProject.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    TokenService authService;

    @PostMapping("add")
    public ResponseEntity<String> addPost(@Valid @RequestParam String email , @RequestParam String token , @RequestBody Post post){
    
        if(authService.authenticate(email,token))
        {
            postService.addPost(post);
            
            return new ResponseEntity<String>("posted sucessfully" , HttpStatus.OK);
        }
       
        return new ResponseEntity<String>("failed" , HttpStatus.BAD_REQUEST);
    }

    @GetMapping("get")
    public ResponseEntity<List<Post>> getAllPosts(@RequestParam String email , @RequestParam String token){
      
        List<Post> postList = null;
        if(authService.authenticate(email,token))
        {
            postList = postService.getAllPosts(token);
            return new ResponseEntity<List<Post>>(postList , HttpStatus.OK);
        }
       

        return new ResponseEntity<List<Post>>(postList , HttpStatus.BAD_REQUEST);
    }
}
