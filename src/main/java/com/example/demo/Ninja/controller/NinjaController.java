package com.example.demo.Ninja.controller;

import com.example.demo.Ninja.dto.NinjaDTO;
import com.example.demo.Ninja.model.NinjaModel;
import com.example.demo.Ninja.service.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "/ninjas")
public class NinjaController {

    @Autowired
    private NinjaService ninjaService;

    @GetMapping(value = "/{id}")

    public ResponseEntity<?> findByIdNinja(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.findByIdNinja(id);

        if(ninja != null){
            return ResponseEntity.ok(ninja);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id: "+ id + " Não encontrado");
        }
    }

    @GetMapping()
    public ResponseEntity<List<NinjaDTO> >FindAll() {
        List<NinjaDTO> ninjas = ninjaService.findAllNinja();
        return ResponseEntity.ok(ninjas);
    }

    @PostMapping("/criar")
    public ResponseEntity<String> create(@RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaDTO = ninjaService.createNinja(ninja);

        return ResponseEntity.status(HttpStatus.CREATED).body("Criado com sucesso: " + ninjaDTO.getNome() + "(ID): " + ninjaDTO.getId());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNinja(@PathVariable Long id) {

        if (ninjaService.findByIdNinja(id) != null) {
            ninjaService.deleteNinja(id);
            return ResponseEntity.ok().body("Ninja com id: " + id + " deletado com sucesso");

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id " + id + " não encontrado!");
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninja) {
       NinjaDTO ninjaAtualizado = ninjaService.updateNinja(id, ninja);
        if (ninjaAtualizado != null) {
            return ResponseEntity.ok().body(ninjaAtualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id " + id + " não encontrado!");
        }
    }



}
