package com.geekster.InstagramProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geekster.InstagramProject.model.Admin;

public interface AdminRepo extends JpaRepository<Admin, Long>{
	
	

}
