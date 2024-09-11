package com.projetointegrador.alugacarro.service;

import com.projetointegrador.alugacarro.model.Cidade;
import com.projetointegrador.alugacarro.repository.CidadeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    CidadeRepository cidadeRepository;

//    @Transactional
    public Cidade save(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }

    public List<Cidade> findAll() {
        return cidadeRepository.findAll();
    }
}
