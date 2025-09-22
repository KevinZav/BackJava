package com.kevinzav.backj.infraestructure.repositories.auth;

import com.kevinzav.backj.infraestructure.models.auth.AuthDb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataAuthJpaRepository extends JpaRepository<AuthDb, Long> {
    Optional<AuthDb> findByUsername(String username);
}
