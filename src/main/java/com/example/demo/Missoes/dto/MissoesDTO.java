package com.example.demo.Missoes.dto;

import com.example.demo.Ninja.model.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MissoesDTO {
    private Long id;
    private String nome;
    private String dificuldade;

    private List<NinjaModel> ninja;
}
