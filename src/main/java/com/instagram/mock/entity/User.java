package com.instagram.mock.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="users", schema = "instagram")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    @NotNull(message = "Username cannot be null")
    @NotBlank(message = "Username cannot be empty")
    @Size(max = 100)
    private String username;

    @Column(name = "password")
    @Size(max = 100)
    @NotNull(message = "Password cannot be null")
    @NotBlank(message = "Password cannot be empty")
    private String password;

    @Column(name = "email")
    @Size(max = 120)
    private String email;

    @Column(name = "phone")
    @Size(max = 20)
    private String phone;

    @Column(name = "avatar_path")
    @Size(max = 250)
    private String avatarPath;

    @Column(name = "created_at")
    @NotNull(message = "Creation time cannot be null")
    private LocalDateTime createdAt;

    @Column(name = "ip")
    @Size(max = 50)
    @NotNull(message = "Ip cannot be null")
    @NotBlank(message = "Ip cannot be empty")
    private String ip;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts;

     public void addPost(Post post){
         if (posts == null){
             posts = new ArrayList<>();
         }
         posts.add(post);
     }
}
