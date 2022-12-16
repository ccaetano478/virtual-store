package com.dev.virtualStore.service;

import com.dev.virtualStore.entity.Estado;
import com.dev.virtualStore.entity.Marca;
import com.dev.virtualStore.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MarcaService {
    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> buscarTodas(){
        return marcaRepository.findAll();
    }

    public Marca inserir (Marca marca){
        marca.setDataCriacao(new Date());
        return marcaRepository.saveAndFlush(marca);

    }
    public Marca alterar (Marca marca){
        marca.setDataAtualizacao(new Date());
        return marcaRepository.saveAndFlush(marca);
    }

    public void excluir (Long id){
        Marca marca = marcaRepository.findById(id).get();
        marcaRepository.delete(marca);
    }
}
