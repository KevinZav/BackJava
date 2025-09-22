package com.kevinzav.backj.domain.models.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Auth {
    private Long id;
    private String username;
    private String password;

    public Auth(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
