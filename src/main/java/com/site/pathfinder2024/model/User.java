package com.site.pathfinder2024.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "full_name", nullable = false)
    private String fullname;

    private Integer age;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Level level;

    @ManyToMany
    private Set<Role> roles;

    public User() {
        Role userRole = new Role();
//        userRole.setName(UserRoles.USER);
//        this.roles = new HashSet<>();
//        this.roles.add(userRole);

    }
}
