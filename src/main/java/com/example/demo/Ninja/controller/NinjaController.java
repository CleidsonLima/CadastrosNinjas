package com.example.demo.Ninja.controller;

import com.example.demo.Ninja.dto.NinjaDTO;
import com.example.demo.Ninja.model.NinjaModel;
import com.example.demo.Ninja.service.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "/ninjas")
public class NinjaController {

    @Autowired
    private NinjaService ninjaService;

    @GetMapping (value = "/{id}")

        public NinjaDTO findByIdNinja(@PathVariable Long id){
        return ninjaService.findByIdNinja(id);
        }


    @GetMapping()
    public List<NinjaDTO> FindAll() {
        return ninjaService.findAllNinja();
    }

    @PostMapping("/criar")
    public NinjaDTO create(@RequestBody NinjaDTO ninja){
         return ninjaService.createNinja(ninja);

    }

    @DeleteMapping("/{id}")
    public void deleteNinja(@PathVariable Long id){
        ninjaService.deleteNinja(id);
    }


    @PutMapping("/{id}")
    public NinjaDTO updateNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninja){
        return ninjaService.updateNinja(id, ninja);
    }


}
