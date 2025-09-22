package com.kevinzav.backj.infraestructure.repositories;

import com.kevinzav.backj.domain.repositories.JwtRepository;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtImplementationRepository implements JwtRepository {
    private final String SECRET = "ONEDSADLKHDSAHDJASHDKJAHDKJSDHAJKSDHAJSKDHJASKD";
    private final long EXPIRATION = 1000 * 60 * 60 * 24;
    private final Key KEY = Keys.hmacShaKeyFor(SECRET.getBytes());

    @Override
    public String generate(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    @Override
    public String getUsernameFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(KEY).build()
                .parseClaimsJws(token).getBody().getSubject();
    }

    @Override
    public boolean validate(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(KEY).build().parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
}
