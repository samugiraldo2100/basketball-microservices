package com.example.players.service;

import com.example.players.model.Jugador;
import com.example.players.repository.JugadorRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class JugadorService {
    private final JugadorRepository repo;

    public JugadorService(JugadorRepository repo) { this.repo = repo; }

    public Flux<Jugador> all() { return repo.findAll(); }
    public Mono<Jugador> byId(Integer id) { return repo.findById(id); }
    public Flux<Jugador> byEquipoId(Integer equipoId) { return repo.findByEquipoId(equipoId); }
    public Mono<Jugador> create(Jugador j) { return repo.save(j); }
    public Mono<Jugador> update(Integer id, Jugador j) {
        return repo.findById(id).flatMap(old -> repo.save(new Jugador(id, j.fullName(), j.position(), j.jerseyNumber(), j.equipoId())));
    }
    public Mono<Void> delete(Integer id) { return repo.deleteById(id); }
}

