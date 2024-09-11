package com.projetointegrador.alugacarro.controller;

import com.projetointegrador.alugacarro.model.Produto;
import com.projetointegrador.alugacarro.model.dto.ProdutoDTO;
import com.projetointegrador.alugacarro.service.ProdutoService;

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
@RequestMapping("/produto")
public class ProdutoCotroller {

    @Autowired
    ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Object> salvaProduto(@RequestBody @Valid ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        BeanUtils.copyProperties(produtoDTO, produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produto));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listaTodosProdutos(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscaProdutoPeloId(@PathVariable(value = "id") Long id) {
        Optional<Produto> produtoOptional = produtoService.findById(id);
        return produtoOptional.<ResponseEntity<Object>>map(produto -> ResponseEntity.status(HttpStatus.OK).body(produto))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado com o ID indicado."));
    }

    @GetMapping("/produto-categoria/{categoria}")
    public ResponseEntity<List<Produto>> buscaProdutoPelaCategoria(@PathVariable(value = "categoria") String categoria) {
//        Optional<List<Produto>> produtoOptional =  produtoService.findByCategoria(categoria);
//        return produtoOptional.map(produto -> ResponseEntity.status(HttpStatus.OK).body(produto))
//                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado com a CATEGORIA indicada."));

        Optional<List<Produto>> produto = produtoService.findByCategoria(categoria);
        if(produto.isEmpty()){
            return new ResponseEntity("Nenhum produto encontrado com a CATEGORIA buscada.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(produto, HttpStatus.OK);
    }
}
