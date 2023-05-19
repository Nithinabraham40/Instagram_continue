package com.geekster.InstagramProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geekster.InstagramProject.model.InstagramComment;
import com.geekster.InstagramProject.service.CommentServise;

@RestController
@RequestMapping("comment")
public class CommentController {

    @Autowired
   private CommentServise commentService;

   @PostMapping("/add")
   String addComment(@RequestBody InstagramComment comment)
   {
       return commentService.addComment(comment);
   }
}
