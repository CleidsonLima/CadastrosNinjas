package com.example.demo.Ninja.controller;

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

        public NinjaModel findByIdNinja(@PathVariable Long id){
        return ninjaService.findByIdNinja(id);
        }


    @GetMapping()
    public List<NinjaModel> FindAll() {
        return ninjaService.findAllNinja();
    }

    @PostMapping("/criar")
    public NinjaModel create(@RequestBody NinjaModel ninja){
         return ninjaService.createNinja(ninja);

    }

    @DeleteMapping("/{id}")
    public void deleteNinja(@PathVariable Long id){
        ninjaService.deleteNinja(id);
    }


    @PutMapping("/{id}")
    public NinjaModel updateNinjaPorId(@PathVariable Long id, @RequestBody NinjaModel ninja){
        return ninjaService.updateNinja(id, ninja);
    }


}
