package com.projetointegrador.alugacarro.model.dto;



import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaDTO {

    @NotBlank
    private String qualificacao;
    @NotBlank
    private String descricao;
    @NotBlank
    private String urlImagem;
}
