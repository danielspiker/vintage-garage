package com.projetointegrador.alugacarro.controller;

import com.projetointegrador.alugacarro.model.Cidade;
import com.projetointegrador.alugacarro.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/cidade")
public class CidadeController {

    @Autowired
    CidadeService cidadeService;

    @PostMapping
    public ResponseEntity<Object> salvaCidade(@RequestBody Cidade cidade) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cidadeService.save(cidade));
    }

    @GetMapping
    public ResponseEntity<List<Cidade>> listaTodasCidades() {
        return ResponseEntity.status(HttpStatus.OK).body(cidadeService.findAll());
    }
}
