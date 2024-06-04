package com.pfe.hostelmangement.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class BlogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    private List<CommentEntity> comments;

}
