package com.geekster.InstagramProject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.geekster.InstagramProject.model.PostLike;

public interface LikeRepo extends JpaRepository<PostLike, Long> {

	
	@Query(value="Select * from tbl_postlikes where fk_postid=:postId",
			
			nativeQuery = true)

	List<PostLike> countPostId(Long postId);

}
