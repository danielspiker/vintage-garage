package com.projetointegrador.alugacarro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CARACTERISTICAS")
public class Caracteristica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
//    @ManyToMany
//    @JoinTable(name = "CARACTERISTICAS_PRODUTOS",
//            joinColumns = @JoinColumn(name = "CARACTERISTICA_ID"),
//            inverseJoinColumns = @JoinColumn(name = "PRODUTO_ID"))
//    private List<Produto> produtos = new ArrayList<>();
}
