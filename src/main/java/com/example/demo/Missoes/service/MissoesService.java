package com.example.demo.Missoes.service;

import com.example.demo.Missoes.dto.MissoesDTO;
import com.example.demo.Missoes.mapper.MissoesMapper;
import com.example.demo.Missoes.model.MissoesModel;
import com.example.demo.Missoes.repository.MissoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    @Autowired
    private MissoesRepository missoesRepository;

    @Autowired
    private MissoesMapper missoesMapper;

//    //Listartodos
    public List<MissoesDTO> findAllMissoes() {
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());

    }
    public MissoesDTO findByIdMissoes(Long id){
        Optional<MissoesModel> missoesId = missoesRepository.findById(id);
        return missoesId.map(missoesMapper::map)
                .orElse(null);
    }
    public MissoesDTO criarMissoes(MissoesDTO missoesDTO){
        MissoesModel missoes = new MissoesMapper().map(missoesDTO);
        missoes = missoesRepository.save(missoes);
        return  missoesMapper.map(missoes);
    }
    public void deleteMissoesPorId(Long id){
        missoesRepository.deleteById(id);
    }

    public MissoesDTO updateMissoes(Long id, MissoesDTO missoesDTO){
        Optional<MissoesModel> missaoExistente = missoesRepository.findById(id);
        if (missaoExistente.isPresent()){
            MissoesModel missaoAtualizada = missoesMapper.map(missoesDTO);
            missaoAtualizada.setId(id);
            MissoesModel missaoSalva = missoesRepository.save(missaoAtualizada);
            return missoesMapper.map(missaoSalva);
        }
        return  null;
    }
}
