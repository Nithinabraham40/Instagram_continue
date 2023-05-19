package com.geekster.InstagramProject.service;

import com.geekster.InstagramProject.dto.SignInInput;
import com.geekster.InstagramProject.dto.SignInOutput;
import com.geekster.InstagramProject.dto.SignUpInput;
import com.geekster.InstagramProject.dto.SignUpOutput;
import com.geekster.InstagramProject.model.AuthenticationToken;
import com.geekster.InstagramProject.model.PostLike;
import com.geekster.InstagramProject.model.User;
import com.geekster.InstagramProject.repo.ITokenRepo;
import com.geekster.InstagramProject.repo.IUserRepo;

import jakarta.transaction.Transactional;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {

    @Autowired
    IUserRepo userRepo;

    @Autowired
    ITokenRepo tokenRepo;
    
    @Autowired
    private LikeService likeService;

    @Autowired
    private TokenService tokenService;
    
    
    @Autowired
    private FollowerService followerService;
    
    @Autowired
    private FollowingService followingService;
    
    
    
    public SignUpOutput signUp(SignUpInput signUpDto) {
        
        User user = userRepo.findFirstByEmail(signUpDto.getEmail());

        if(user != null)
        {
            throw new IllegalStateException("Instagram user already exists!!!!...sign in instead");
        }


        String encryptedPassword = null;

        try {
            encryptedPassword = encryptPassword(signUpDto.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        user = new User(signUpDto.getFirstName(), signUpDto.getLastName(),
                encryptedPassword , signUpDto.getAge() , signUpDto.getEmail(), signUpDto.getPhoneNumber());

        userRepo.save(user);

        return new SignUpOutput("Instagram user registered","Instagram account created successfully");

    }

    private String encryptPassword(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");

        md5.update(userPassword.getBytes());
        byte[] digested = md5.digest();

        String hash = DatatypeConverter.printHexBinary(digested);

        return hash;

    }

    public SignInOutput signIn(SignInInput signInDto) {
        
        User user = userRepo.findFirstByEmail(signInDto.getEmail());

        if(user == null)
        {
            throw new IllegalStateException("User invalid!!!!...sign up instead");
        }

        String encryptedPassword = null;

        try {
            encryptedPassword = encryptPassword(signInDto.getPassword());
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

        }

      

        boolean isPasswordValid = encryptedPassword.equals(user.getPassword());

        if(!isPasswordValid)
        {
            throw new IllegalStateException("User invalid!!!!...sign up instead");
        }

        AuthenticationToken token = new AuthenticationToken(user);

        tokenService.saveToken(token);

      

        return new SignInOutput("Authentication Successfull !!!", token.getToken());


    }

    public String toggleBlueTick(Long id, boolean blueTick) {
        User user = userRepo.findByUserId(id);

        if(user!=null) {
           user.setBlueTicked(blueTick);
           userRepo.save(user);
            return "Blue tick was set to" + blueTick;
        }
        
           return "user doesn't exist";
        

    }

    public void like(PostLike postLike) {
        likeService.like(postLike);
    }

    @Transactional
    public String followUser(Long myId, Long otherId) {

        if(myId == otherId)
        {
            return "Cant follow yourself!!!!";
        }
       User myUser = userRepo.findByUserId(myId);
       User otherUser = userRepo.findByUserId(otherId);

        if(myUser!=null && otherUser!=null) {

            followingService.saveFollowing(myUser,otherUser);

          
            followerService.saveFollower(otherUser, myUser);

            return "Followed Successfully!!!!!";
        }
        
            return "Users are invalid!!!";
        
    }



     




    
}
