package com.projetointegrador.alugacarro.service;

import com.projetointegrador.alugacarro.model.Imagem;
import com.projetointegrador.alugacarro.repository.ImagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImagemService {
    @Autowired
    ImagemRepository imagemRepository;

    public Imagem save(Imagem imagem){
        return imagemRepository.save(imagem);
    }

    public List<Imagem> findAll() {
        return imagemRepository.findAll();
    }
}
