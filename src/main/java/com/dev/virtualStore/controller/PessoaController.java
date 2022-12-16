package com.dev.virtualStore.controller;

import com.dev.virtualStore.entity.Pessoa;
import com.dev.virtualStore.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/")
    public List<Pessoa> buscarTodas(){
        return pessoaService.buscaTodas();
    }

    @PostMapping("/")
    public Pessoa inserir (@RequestBody Pessoa pessoa){
        return pessoaService.inserir(pessoa);
    }

    @PutMapping("/")
    public Pessoa alterar (@RequestBody Pessoa pessoa){
        return pessoaService.alterar(pessoa);
    }

    @DeleteMapping("/")
    public ResponseEntity<Pessoa> excluir(Long id){
        pessoaService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
