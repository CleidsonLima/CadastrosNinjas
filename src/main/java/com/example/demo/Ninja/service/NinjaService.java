package com.example.demo.Ninja.service;

import com.example.demo.Ninja.model.NinjaModel;
import com.example.demo.Ninja.repository.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    @Autowired
    private NinjaRepository ninjaRepository;


    public List<NinjaModel> findAllNinja() {
        return ninjaRepository.findAll();
    }

    public NinjaModel findByIdNinja(Long id) {
        Optional<NinjaModel> findById = ninjaRepository.findById(id);
        return findById.orElse(null);
    }

    public NinjaModel createNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

    public void deleteNinja(Long id) {
        ninjaRepository.deleteById(id);
    }



}
