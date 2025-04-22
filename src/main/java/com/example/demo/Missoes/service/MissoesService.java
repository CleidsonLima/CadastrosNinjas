package com.example.demo.Missoes.service;

import com.example.demo.Missoes.model.MissoesModel;
import com.example.demo.Missoes.repository.MissoesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MissoesService {

    @Autowired
    private MissoesRepository missoesRepository;

    //Listartodos
    public List<MissoesModel> listarTodasMissoes(){
        return missoesRepository.findAll();
    }
}
