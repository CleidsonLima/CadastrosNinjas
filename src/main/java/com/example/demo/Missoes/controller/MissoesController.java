package com.example.demo.Missoes.controller;


import com.example.demo.Missoes.model.MissoesModel;
import com.example.demo.Missoes.repository.MissoesRepository;
import com.example.demo.Missoes.service.MissoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class MissoesController {

    @Autowired
    private MissoesService missoesService;

    @GetMapping("/listarMissoes")
    public List<MissoesModel> listarMissoes(){
        return  missoesService.listarTodasMissoes();
    }
}
