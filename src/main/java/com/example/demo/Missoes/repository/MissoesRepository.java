package com.example.demo.Missoes.repository;

import com.example.demo.Missoes.model.MissoesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissoesRepository extends JpaRepository<MissoesModel, Long> {
}
