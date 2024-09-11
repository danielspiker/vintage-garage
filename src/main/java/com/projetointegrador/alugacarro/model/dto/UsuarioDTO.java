package com.projetointegrador.alugacarro.model.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {


    private String nome;

    private String sobrenome;

    private String email;


    private String senha;

    public UsernamePasswordAuthenticationToken converter() {
        return new  UsernamePasswordAuthenticationToken(this.email, this.senha);
    }
}
