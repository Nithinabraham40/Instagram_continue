package com.geekster.InstagramProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geekster.InstagramProject.model.InstagramFollower;
import com.geekster.InstagramProject.model.User;
import com.geekster.InstagramProject.repo.FollowerRepo;

@Service
public class FollowerService {

    @Autowired
    private FollowerRepo followerRepo;

    public void saveFollower(User myUser, User otherUser) {


        InstagramFollower follower = new InstagramFollower(null,myUser,otherUser);

        followerRepo.save(follower);
    }
}
