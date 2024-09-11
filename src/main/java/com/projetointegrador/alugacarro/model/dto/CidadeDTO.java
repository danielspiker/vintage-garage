package com.projetointegrador.alugacarro.model.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeDTO {
    @NotBlank
    private String nome;
    @NotBlank
    private String pais;
}
