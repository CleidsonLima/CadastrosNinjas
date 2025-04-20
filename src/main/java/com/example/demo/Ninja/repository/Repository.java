package com.example.demo.Ninja.repository;

import com.example.demo.Ninja.model.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository <NinjaModel, Long> {
}
