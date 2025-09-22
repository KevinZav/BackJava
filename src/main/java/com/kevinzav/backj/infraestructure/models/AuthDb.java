package com.kevinzav.backj.infraestructure.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "auth")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class AuthDb {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, name = "username")
    private String username;

    @Column(nullable = false, name = "password")
    private String password;
}
