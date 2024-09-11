package com.projetointegrador.alugacarro.service;

import com.projetointegrador.alugacarro.model.Usuario;
import com.projetointegrador.alugacarro.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UsuarioRepository usuarioRepository;

//    @Transactional
    public Usuario criar(Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarUsuario(String email) {
        return Optional.ofNullable(usuarioRepository.findByEmail(email));
    }



}
