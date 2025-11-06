package com.example.teams.controller;

import com.example.teams.controller.dto.EquipoRequests;
import com.example.teams.model.Equipo;
import com.example.teams.service.EquipoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {
    private final EquipoService service;

    public EquipoController(EquipoService service) { this.service = service; }

    @GetMapping
    public Flux<Equipo> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public Mono<Equipo> byId(@PathVariable Integer id) { return service.findById(id); }

    @PostMapping
    public Mono<Equipo> create(@RequestBody @Valid EquipoRequests.Create req) {
        return service.create(new Equipo(null, req.name(), req.city(), req.conference(), req.championships()));
    }

    @PutMapping("/{id}")
    public Mono<Equipo> update(@PathVariable Integer id, @RequestBody @Valid EquipoRequests.Update req) {
        return service.update(id, new Equipo(null, req.name(), req.city(), req.conference(), req.championships()));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Integer id) { return service.delete(id); }
}


