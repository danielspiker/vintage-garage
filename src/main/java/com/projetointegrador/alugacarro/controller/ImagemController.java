package com.projetointegrador.alugacarro.controller;

import com.projetointegrador.alugacarro.model.Imagem;
import com.projetointegrador.alugacarro.service.ImagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/imagem")
public class ImagemController {

    @Autowired
    ImagemService imagemService;

    @PostMapping
    public ResponseEntity<Object> salvaImagem(@RequestBody Imagem imagem){
        return ResponseEntity.status(HttpStatus.CREATED).body(imagemService.save(imagem));
    }

    @GetMapping
    public ResponseEntity<List<Imagem>> listaTodasImagens() {
        return ResponseEntity.status(HttpStatus.OK).body(imagemService.findAll());
    }
}
