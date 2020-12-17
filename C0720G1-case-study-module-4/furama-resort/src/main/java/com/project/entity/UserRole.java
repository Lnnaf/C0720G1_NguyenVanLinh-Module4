package com.project.entity;

import javax.persistence.*;

@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "username")
    private WebUser webUser;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
