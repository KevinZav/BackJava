package com.kevinzav.backj.domain.repositories;

import com.kevinzav.backj.domain.models.Auth;

import java.util.Optional;

public interface AuthRepository {
    Optional<Auth> findByUsername(String username);
    Auth save(Auth auth);
}
