package com.example.teams.repository;

import com.example.teams.model.Equipo;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EquipoRepository extends ReactiveCrudRepository<Equipo, Integer> {
}

