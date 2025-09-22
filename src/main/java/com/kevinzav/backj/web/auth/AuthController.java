package com.kevinzav.backj.web.auth;

import com.kevinzav.backj.application.auth.AuthService;
import com.kevinzav.backj.infraestructure.models.auth.AuthDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/sign")
    public String sign(@RequestBody AuthDto authDto) {
        return authService.sign(authDto.getUsername(), authDto.getPassword())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "USER_EXISTS"));
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthDto authDto) {
        return authService.login(authDto.getUsername(), authDto.getPassword())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.UNAUTHORIZED,"LOGIN_ERROR"));
    }
}
