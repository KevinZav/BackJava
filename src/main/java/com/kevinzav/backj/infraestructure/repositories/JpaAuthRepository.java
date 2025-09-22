package com.kevinzav.backj.infraestructure.repositories;

import com.kevinzav.backj.domain.models.Auth;
import com.kevinzav.backj.domain.repositories.AuthRepository;
import com.kevinzav.backj.infraestructure.mappers.AuthMapper;
import com.kevinzav.backj.infraestructure.models.AuthDb;
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
        if (!data.isPresent()) {
            return Optional.empty();
        }
        return data.map(AuthMapper::dataToEntity);
    }

    @Override
    public Auth save(Auth auth) {
        AuthDb data = AuthMapper.entityToData(auth);
        AuthDb authSaved = jpa.save(data);

        return AuthMapper.dataToEntity(authSaved);
    }
}
