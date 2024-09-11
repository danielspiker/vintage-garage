package com.projetointegrador.alugacarro.controller;

import com.projetointegrador.alugacarro.config.security.DadosTokenJWT;
import com.projetointegrador.alugacarro.config.security.TokenService;
import com.projetointegrador.alugacarro.model.Usuario;

import com.projetointegrador.alugacarro.model.dto.UsuarioDTO;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/logar")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<Object> logar(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        try {
            UsernamePasswordAuthenticationToken loginUsuario = usuarioDTO.converter();
            Authentication authentication = authenticationManager.authenticate(loginUsuario);
            String token = tokenService.gerarToken((Usuario) authentication.getPrincipal());

//            TokenDTO tokenDTO = new TokenDTO();
//            tokenDTO.setToken(token);
//            tokenDTO.setTipo("Bearer");

            return ResponseEntity.ok(new DadosTokenJWT(token));
        } catch (AuthenticationException exception) {
            return ResponseEntity.badRequest().body("Erro ao tentar autenticar.");
        }
    }

}















