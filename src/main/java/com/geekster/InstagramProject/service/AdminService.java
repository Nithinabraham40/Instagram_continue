package com.geekster.InstagramProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geekster.InstagramProject.repo.AdminRepo;

@Service
public class AdminService {

    @Autowired
    UserService userService;

    @Autowired
    private AdminRepo adminRepo;

    public String toggleBlueTick(Long id, boolean blueTick) {
        return userService.toggleBlueTick(id,blueTick);

    }
}
