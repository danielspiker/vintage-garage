package com.projetointegrador.alugacarro.controller;

import com.projetointegrador.alugacarro.model.Usuario;
import com.projetointegrador.alugacarro.model.dto.UsuarioDTO;
import com.projetointegrador.alugacarro.service.UsuarioService;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {


//    private  final PasswordEncoder encoder;

    @Autowired
    UsuarioService usuarioService;

//    public UsuarioController(PasswordEncoder encoder, UsuarioService usuarioService) {
//        this.encoder = encoder;
//        this.usuarioService = usuarioService;
//    }


    @PostMapping
    public ResponseEntity<Object> salvaUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) {
//        usuarioDTO.setSenha(encoder.encode(usuarioDTO.getSenha()));
        System.out.println("------- SENHA DO USUARIO ------->>> " + usuarioDTO.getSenha());
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDTO, usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.criar(usuario));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listaTodosUsuarios() {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.buscarTodos());
    }

    @GetMapping("/{email}")
    public ResponseEntity<Object> buscaUsuarioPeloEmail(@PathVariable(value = "email") String email) {
        Optional<Usuario> usuarioOptional = usuarioService.buscarUsuario(email);
        return usuarioOptional.<ResponseEntity<Object>>map(usuario -> ResponseEntity.status(HttpStatus.OK).body(usuario))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada."));
    }


}
