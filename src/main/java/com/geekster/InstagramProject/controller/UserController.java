package com.geekster.InstagramProject.controller;

import com.geekster.InstagramProject.dto.SignInInput;
import com.geekster.InstagramProject.dto.SignInOutput;
import com.geekster.InstagramProject.dto.SignUpInput;
import com.geekster.InstagramProject.dto.SignUpOutput;
import com.geekster.InstagramProject.model.Post;
import com.geekster.InstagramProject.model.PostLike;
import com.geekster.InstagramProject.model.User;
import com.geekster.InstagramProject.service.TokenService;
import com.geekster.InstagramProject.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    TokenService authService;

    @PostMapping("/signup")
    public SignUpOutput signUp(@Valid @RequestBody SignUpInput signUpDto){
        return userService.signUp(signUpDto);
    }

    @PostMapping("/signin")
    public SignInOutput signIn(@Valid @RequestBody SignInInput signInDto){
        return userService.signIn(signInDto);
    }

    @DeleteMapping("/signout")
    public ResponseEntity<String> signOut(@RequestParam String email , @RequestParam String token){
       

        if(authService.authenticate(email,token))
        {
            authService.deleteToken(token);
          
            return new ResponseEntity<String>("Signout Successful" , HttpStatus.OK);

        }
       

        return new ResponseEntity<String>("not possible" , HttpStatus.BAD_REQUEST);
    }
    
    @PostMapping("/like")
    void likePost(@RequestBody PostLike postLike)
    {
      
        userService.like(postLike);

    }
    
    @PostMapping("/follow/{myId}/{otherId}")
    String followUser(@PathVariable Long myId, @PathVariable Long otherId)
    {
        return userService.followUser( myId, otherId);
    }

   


}
