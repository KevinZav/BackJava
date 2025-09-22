package com.kevinzav.backj.application;

import com.kevinzav.backj.domain.models.Auth;
import com.kevinzav.backj.domain.repositories.AuthRepository;
import com.kevinzav.backj.domain.repositories.JwtRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class AuthService {
    private final AuthRepository authRepository;
    private final PasswordEncoder encoder;
    private final JwtRepository jwtRepository;

    public AuthService(AuthRepository authRepository, PasswordEncoder encoder, JwtRepository jwtRepository) {
        this.authRepository = authRepository;
        this.encoder = encoder;
        this.jwtRepository = jwtRepository;
    }

    public Optional<String> sign(String username, String password) {
        authRepository.findByUsername(username).ifPresent(auth -> { throw new RuntimeException("AUTH EXISTS"); });

        Auth auth = new Auth(null, username, encoder.encode(password));
        authRepository.save(auth);

        return Optional.of(jwtRepository.generate(username));
    }

    public Optional<String> login(String username, String password) {
        Optional<Auth> auth = authRepository.findByUsername(username);

        if (!auth.isPresent()) {
            throw new RuntimeException("AUTH NOT EXISTS");
        }

        boolean isMatch = encoder.matches(password, auth.get().getPassword());

        if (!isMatch) {
            throw new RuntimeException("AUTHENTICATION FAILED");
        }

        return Optional.of(jwtRepository.generate(username));
    }

}
