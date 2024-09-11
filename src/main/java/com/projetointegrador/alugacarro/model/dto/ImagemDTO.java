package com.projetointegrador.alugacarro.model.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImagemDTO {

    @NotBlank
    private String titulo;
    @NotBlank
    private String url;
}
