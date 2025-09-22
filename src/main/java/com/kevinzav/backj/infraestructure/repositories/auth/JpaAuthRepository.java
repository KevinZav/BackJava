package com.kevinzav.backj.infraestructure.repositories.auth;

import com.kevinzav.backj.domain.models.auth.Auth;
import com.kevinzav.backj.domain.repositories.auth.AuthRepository;
import com.kevinzav.backj.infraestructure.mappers.auth.AuthMapper;
import com.kevinzav.backj.infraestructure.models.auth.AuthDb;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaAuthRepository implements AuthRepository {
    private final SpringDataAuthJpaRepository jpa;

    public JpaAuthRepository(SpringDataAuthJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Optional<Auth> findByUsername(String username) {
        Optional<AuthDb> data = jpa.findByUsername(username);
        if (data.isEmpty()) {
            return Optional.empty();
        }
        return data.map(AuthMapper.INSTANCE::dataToEntity);
    }

    @Override
    public Auth save(Auth auth) {
        AuthDb data = AuthMapper.INSTANCE.entityToData(auth);
        AuthDb authSaved = jpa.save(data);

        return AuthMapper.INSTANCE.dataToEntity(authSaved);
    }
}
