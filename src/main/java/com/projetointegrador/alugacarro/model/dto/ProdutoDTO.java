package com.projetointegrador.alugacarro.model.dto;

import com.projetointegrador.alugacarro.model.Caracteristica;
import com.projetointegrador.alugacarro.model.Categoria;
import com.projetointegrador.alugacarro.model.Cidade;
import com.projetointegrador.alugacarro.model.Imagem;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProdutoDTO {
    private String nome;
    private String descricao;

    private Categoria categoria;
    private Cidade cidade;
    private List<Imagem> imagens;

    private List<Caracteristica> caracteristicas;

}
