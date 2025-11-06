package com.example.players.repository;

import com.example.players.model.Jugador;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface JugadorRepository extends ReactiveCrudRepository<Jugador, Integer> {
    Flux<Jugador> findByEquipoId(Integer equipoId);
}

