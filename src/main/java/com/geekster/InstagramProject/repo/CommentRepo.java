package com.geekster.InstagramProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geekster.InstagramProject.model.InstagramComment;

public interface CommentRepo extends JpaRepository<InstagramComment, Long> {
	

}
