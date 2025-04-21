package com.example.demo.Missoes.model;

import com.example.demo.Ninja.model.NinjaModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)


@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String nome;
    private String dificuldade;

    @OneToMany(mappedBy ="missoes")
    private List<NinjaModel> ninja;
}
