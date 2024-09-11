package com.projetointegrador.alugacarro.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "FUNCOES")
public class Funcao implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @Override
    public String getAuthority() {
        return this.descricao;
    }

}
