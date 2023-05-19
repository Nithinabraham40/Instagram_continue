package com.geekster.InstagramProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geekster.InstagramProject.model.InstagramComment;
import com.geekster.InstagramProject.repo.CommentRepo;
@Service
public class CommentServise {

	 @Autowired
	    private CommentRepo commentRepo;

	    
	    public String addComment(InstagramComment comment) {
	        InstagramComment rComment = commentRepo.save(comment);
	        if(rComment == null){return "comment not saved"; }
	       
	       
	            return "Comment saved sucessfully";
	        
	    }

}
