package com.geekster.InstagramProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_Followers")
public class InstagramFollower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long followerId;

    @OneToOne
    private User user;

    @OneToOne
    private User follower;



}
