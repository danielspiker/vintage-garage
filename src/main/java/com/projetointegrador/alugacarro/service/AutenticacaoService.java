package com.projetointegrador.alugacarro.service;

import com.projetointegrador.alugacarro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            return repository.findByEmail(username);
        } catch (UsernameNotFoundException exception) {
            throw new UsernameNotFoundException("Usuário não existente.");
        }

    }
}
