package com.kevinzav.backj.infraestructure.config;

import com.kevinzav.backj.application.AuthService;
import com.kevinzav.backj.infraestructure.repositories.JpaAuthRepository;
import com.kevinzav.backj.infraestructure.repositories.JwtImplementationRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BeanConfig {
    @Bean
    public AuthService authService(JpaAuthRepository authRepository, PasswordEncoder encoder, JwtImplementationRepository jwtRepository) {
        return new AuthService(authRepository, encoder, jwtRepository);
    }
}
