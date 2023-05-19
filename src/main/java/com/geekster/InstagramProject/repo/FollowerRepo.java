package com.geekster.InstagramProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geekster.InstagramProject.model.InstagramFollower;

public interface FollowerRepo extends JpaRepository<InstagramFollower, Long>{
	
	

}
