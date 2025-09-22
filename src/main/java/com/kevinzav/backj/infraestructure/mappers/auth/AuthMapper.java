package com.kevinzav.backj.infraestructure.mappers.auth;

import com.kevinzav.backj.domain.models.auth.Auth;
import com.kevinzav.backj.infraestructure.models.auth.AuthDb;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper
public interface AuthMapper {
    AuthMapper INSTANCE = Mappers.getMapper(AuthMapper.class);

    Auth dataToEntity(AuthDb data);

    AuthDb entityToData(Auth entity);

}
