package com.kevinzav.backj.web;

import com.kevinzav.backj.application.AuthService;
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
    public String sign(@RequestParam String username, @RequestParam String password) {
        return authService.sign(username, password)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "USER_EXISTS"));
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        return authService.login(username, password)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.UNAUTHORIZED,"LOGIN_ERROR"));
    }
}
