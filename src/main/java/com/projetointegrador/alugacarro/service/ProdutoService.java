package com.projetointegrador.alugacarro.service;

import com.projetointegrador.alugacarro.model.Produto;
import com.projetointegrador.alugacarro.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

//    @Transactional
    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public void delete(Produto produto) {
        produtoRepository.delete(produto);
    }

    public Optional<Produto> findById(Long id) {
        return produtoRepository.findById(id);
    }

    public Optional<List<Produto>> findByCategoria(String descricao) {
        return produtoRepository.findByCategoriaQualificacao(descricao);
    }
}
