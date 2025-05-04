package com.example.demo.Ninja.controller;

import com.example.demo.Ninja.dto.NinjaDTO;
import com.example.demo.Ninja.model.NinjaModel;
import com.example.demo.Ninja.service.NinjaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Lista ninja por ID", description = "Rota lista um ninja por seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404",description = "Erro ao encontrar ninja")
    })
    public ResponseEntity<?> findByIdNinja(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.findByIdNinja(id);

        if(ninja != null){
            return ResponseEntity.ok(ninja);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id: "+ id + " Não encontrado");
        }
    }

    @GetMapping()
    @Operation(summary = "Lista todos os ninjas", description = "Rota lista todos os ninjas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Ninjas encontrados com sucesso"),
            @ApiResponse(responseCode = "404",description = "Erro ao encontrar ninjas")})

    public ResponseEntity<List<NinjaDTO> >FindAll() {
        List<NinjaDTO> ninjas = ninjaService.findAllNinja();
        return ResponseEntity.ok(ninjas);
    }

    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja", description = "rota cria um novo ninja e insere no BD")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400",description = "Erro na criação do ninja")
    })
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
    @Operation(summary = "Alterar ninja por ID", description = "Rota altera um ninja por seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "404",description = "Não foi possivel alterar ninja")})
    public ResponseEntity<?> updateNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninja) {
       NinjaDTO ninjaAtualizado = ninjaService.updateNinja(id, ninja);
        if (ninjaAtualizado != null) {
            return ResponseEntity.ok().body(ninjaAtualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id " + id + " não encontrado!");
        }
    }



}
