package com.projetointegrador.alugacarro.controller;

import com.projetointegrador.alugacarro.model.Caracteristica;
import com.projetointegrador.alugacarro.service.CaracteristicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/caracteristica")
public class CaracteristicaController {

    @Autowired
    CaracteristicaService caracteristicaService;

    @PostMapping
    public ResponseEntity<Object> salvaCaracteristica(@RequestBody Caracteristica caracteristica) {
        return ResponseEntity.status(HttpStatus.CREATED).body(caracteristicaService.save(caracteristica));
    }

    @GetMapping
    public ResponseEntity<List<Caracteristica>> listaTodasCaracteristicas() {
        return ResponseEntity.status(HttpStatus.OK).body(caracteristicaService.findAll());
    }
}
