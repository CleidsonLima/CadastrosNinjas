package com.example.demo.Ninja.dto;

import com.example.demo.Missoes.model.MissoesModel;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class NinjaDTO {



    private Long id;
    private String nome;
    private String email;
    private Integer idade;
    private String rank;
    private MissoesModel missoes;


}
