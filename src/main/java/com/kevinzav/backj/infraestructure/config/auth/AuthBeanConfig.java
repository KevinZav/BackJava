package com.kevinzav.backj.infraestructure.config.auth;

import com.kevinzav.backj.application.auth.AuthService;
import com.kevinzav.backj.infraestructure.repositories.auth.JpaAuthRepository;
import com.kevinzav.backj.infraestructure.repositories.token.JwtImplementationRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AuthBeanConfig {
    @Bean
    public AuthService authService(JpaAuthRepository authRepository, PasswordEncoder encoder, JwtImplementationRepository jwtRepository) {
        return new AuthService(authRepository, encoder, jwtRepository);
    }
}
