package com.kevinzav.backj.domain.repositories;

public interface JwtRepository {
    String generate(String username);
    String getUsernameFromToken(String token);
    boolean validate(String token);
}
