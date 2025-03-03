package com.satgat.project_manager_backend.controller;

import org.springframework.web.bind.annotation.RestController;
import com.satgat.project_manager_backend.model.dto.LoginDTO;
import com.satgat.project_manager_backend.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody LoginDTO loginDTO) {
        boolean isLoginSuccessful = loginService.login(loginDTO);
        if (isLoginSuccessful) {
            return ResponseEntity.ok("login Successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("login Failed");
        }
    }
}
