package com.example.teams.service;

import com.example.teams.model.Equipo;
import com.example.teams.repository.EquipoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EquipoService {
    private final EquipoRepository repo;

    public EquipoService(EquipoRepository repo) {
        this.repo = repo;
    }

    public Flux<Equipo> findAll() { return repo.findAll(); }
    public Mono<Equipo> findById(Integer id) { return repo.findById(id); }
    public Mono<Equipo> create(Equipo e) { return repo.save(e); }
    public Mono<Equipo> update(Integer id, Equipo e) {
        return repo.findById(id)
            .flatMap(old -> repo.save(new Equipo(id, e.name(), e.city(), e.conference(), e.championships())));
    }
    public Mono<Void> delete(Integer id) { return repo.deleteById(id); }
}

