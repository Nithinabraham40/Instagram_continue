package com.geekster.InstagramProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geekster.InstagramProject.model.InstagramFollowing;
import com.geekster.InstagramProject.model.User;
import com.geekster.InstagramProject.repo.FollowingRepo;

@Service
public class FollowingService {

    @Autowired
    private FollowingRepo followingRepo;

    public void saveFollowing(User myUser, User otherUser) {
        InstagramFollowing followingRecord = new InstagramFollowing(null,myUser,otherUser);
        followingRepo.save(followingRecord);
    }
}
