package com.projetointegrador.alugacarro.service;

import com.projetointegrador.alugacarro.model.Categoria;
import com.projetointegrador.alugacarro.repository.CategoriaRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

//    @Transactional
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    }

    @Transactional
    public void delete(Categoria categoria) {
        categoriaRepository.delete(categoria);
    }
}
