package com.kevinzav.backj.domain.repositories.auth;

import com.kevinzav.backj.domain.models.auth.Auth;

import java.util.Optional;

public interface AuthRepository {
    Optional<Auth> findByUsername(String username);
    Auth save(Auth auth);
}
