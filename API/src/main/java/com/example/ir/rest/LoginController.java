package com.example.ir.rest;

import com.example.ir.config.FonctionnelException;
import com.example.ir.dto.LoginDTO;
import com.example.ir.dto.UtilisateurDTO;
import com.example.ir.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<UtilisateurDTO> login(@RequestBody LoginDTO loginDTO) throws FonctionnelException {
        return ResponseEntity.ok().body(loginService.login(loginDTO));
    }

}
