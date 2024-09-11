package com.projetointegrador.alugacarro.controller;

import com.projetointegrador.alugacarro.model.Categoria;
import com.projetointegrador.alugacarro.model.dto.CategoriaDTO;
import com.projetointegrador.alugacarro.service.CategoriaService;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Object> salvaCategoria(@RequestBody @Valid CategoriaDTO categoriaDTO) {
        Categoria categoria = new Categoria();
        BeanUtils.copyProperties(categoriaDTO, categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.save(categoria));
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listaTodasCategorias(){
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscaCategoriaPeloId(@PathVariable(value = "id") Long id) {
        Optional<Categoria> categoriaOptional = categoriaService.findById(id);
        return categoriaOptional.<ResponseEntity<Object>>map(categoria -> ResponseEntity.status(HttpStatus.OK).body(categoria))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada."));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluiCategoriaPeloId(@PathVariable(value = "id") Long id) {
        Optional<Categoria> categoriaOptional = categoriaService.findById(id);
        if(categoriaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada.");
        }
        categoriaService.delete(categoriaOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Categoria excluída.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizaCategoria(@PathVariable(value = "id") Long id,
                                                    @RequestBody @Valid CategoriaDTO categoriaDTO) {
        Optional<Categoria> categoriaOptional = categoriaService.findById(id);
        if(!categoriaOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada.");
        }
        Categoria categoria = new Categoria();
        BeanUtils.copyProperties(categoriaDTO, categoria);
        categoria.setId(categoriaOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.save(categoria));
    }

}










