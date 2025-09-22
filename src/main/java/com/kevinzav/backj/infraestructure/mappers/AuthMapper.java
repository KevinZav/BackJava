package com.kevinzav.backj.infraestructure.mappers;

import com.kevinzav.backj.domain.models.Auth;
import com.kevinzav.backj.infraestructure.models.AuthDb;

public class AuthMapper {
    public static Auth dataToEntity(AuthDb data) {
        return new Auth(data.getId(), data.getUsername(), data.getPassword());
    }

    public static AuthDb entityToData(Auth entity) {
        return new AuthDb(entity.getId(), entity.getUsername(), entity.getPassword());
    }
}
