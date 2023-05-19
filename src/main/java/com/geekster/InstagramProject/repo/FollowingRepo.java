package com.geekster.InstagramProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geekster.InstagramProject.model.InstagramFollowing;

public interface FollowingRepo extends JpaRepository<InstagramFollowing, Long>{
	
	  Long countByUser_userId(long userId);

}
