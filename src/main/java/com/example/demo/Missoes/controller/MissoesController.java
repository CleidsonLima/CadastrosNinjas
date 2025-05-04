package com.example.demo.Missoes.controller;


import com.example.demo.Missoes.dto.MissoesDTO;
import com.example.demo.Missoes.model.MissoesModel;
import com.example.demo.Missoes.repository.MissoesRepository;
import com.example.demo.Missoes.service.MissoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "/missoes")
public class MissoesController {

    @Autowired
    private MissoesService missoesService;

    @GetMapping()
    public ResponseEntity<List<MissoesDTO>> listarMissoes(){
        List<MissoesDTO> missoes = missoesService.findAllMissoes();
        return ResponseEntity.ok(missoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdMissoes(@PathVariable Long id){
        MissoesDTO missoes = missoesService.findByIdMissoes(id);
        if(missoes!=null){
            return ResponseEntity.ok(missoes);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id " +id+ " Não existente");
        }
    }
    @PostMapping("/criar")
    public ResponseEntity<MissoesDTO> create (@RequestBody MissoesDTO missoes){
        MissoesDTO missoesDTO = missoesService.criarMissoes(missoes);

        return ResponseEntity.status(HttpStatus.CREATED).body(missoes);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(Long id){

        if(missoesService.findByIdMissoes(id) != null){
            missoesService.deleteMissoesPorId(id);
            return ResponseEntity.ok().body("Id:" + id + " deletado com sucesso");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id: " +id+ " não encontrado");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateMissoes(@PathVariable Long id, @RequestBody MissoesDTO missoes){
        MissoesDTO missoesDTO = missoesService.updateMissoes(id, missoes);
        if(missoesDTO!=null){
            return ResponseEntity.ok().body(missoesDTO);
        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id: " +id+ " não encontrado!");
        }
    }
}
