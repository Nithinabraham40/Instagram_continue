package com.geekster.InstagramProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_postlikes")
public class PostLike {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeId;


    @ManyToOne
    @JoinColumn(nullable = false , name = "fk_postID")
    private Post post;

    @ManyToOne
    @JoinColumn(nullable = false , name = "fk_userID")
    private User user;
}
