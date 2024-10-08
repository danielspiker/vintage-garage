package com.projetointegrador.alugacarro.repository;

import com.projetointegrador.alugacarro.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Optional<List<Produto>> findByCategoriaQualificacao(String descricao);
}
