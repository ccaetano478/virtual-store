package com.dev.virtualStore.controller;

import com.dev.virtualStore.entity.Cidade;
import com.dev.virtualStore.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cidade")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping("/")
    public List<Cidade> buscarTodas(){
        return cidadeService.buscarTodas();
    }

    @PostMapping("/")
    public Cidade inserir (@RequestBody Cidade cidade){

        return cidadeService.inserir(cidade);
    }

    @PutMapping("/")
    public Cidade alterar (@RequestBody Cidade cidade){
       return cidadeService.alterar(cidade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cidade> excluir (@PathVariable("id") Long id){
       cidadeService.excluir(id);
       return ResponseEntity.ok().build();
    }
}
