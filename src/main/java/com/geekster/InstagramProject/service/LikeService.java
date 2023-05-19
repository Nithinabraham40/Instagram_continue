package com.geekster.InstagramProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geekster.InstagramProject.model.PostLike;
import com.geekster.InstagramProject.repo.LikeRepo;

@Service
public class LikeService {

    @Autowired
    private LikeRepo likeRepo;

    public void like(PostLike postLike) {
        likeRepo.save(postLike);
    }

    public long getLikes(Long postId) {
       
       List<PostLike>allPost= likeRepo.countPostId(postId);
       return allPost.size();
    }
}
