package com.pfe.hostelmangement.entities;

import jakarta.persistence.*;

@Entity
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "blog_id")
    private BlogEntity blog;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
