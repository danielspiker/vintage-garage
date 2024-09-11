package com.projetointegrador.alugacarro.model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUTOS")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "CATEGORIA_ID")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "CIDADE_ID")
    private Cidade cidade;

    @OneToMany
//            (mappedBy = "produto")
    private List<Imagem> imagens = new ArrayList<>();

    @ManyToMany
//    (mappedBy = "produtos")
    @JoinTable(name = "CARACTERISTICAS_PRODUTOS",
        joinColumns = @JoinColumn(name = "PRODUTO_ID "),
        inverseJoinColumns = @JoinColumn(name = "CARACTERISTICA_ID"))
    private List<Caracteristica> caracteristicas = new ArrayList<>();
}
