package com.example.players.controller;

import com.example.players.controller.dto.JugadorRequests;
import com.example.players.model.Jugador;
import com.example.players.service.JugadorService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorController {
    private final JugadorService service;

    public JugadorController(JugadorService service) { this.service = service; }

    @GetMapping
    public Flux<Jugador> all(@RequestParam(required = false) Integer equipoId) {
        if (equipoId != null) {
            return service.byEquipoId(equipoId);
        }
        return service.all();
    }

    @GetMapping("/{id}")
    public Mono<Jugador> byId(@PathVariable Integer id) { return service.byId(id); }

    @PostMapping
    public Mono<Jugador> create(@RequestBody @Valid JugadorRequests.Create req) {
        return service.create(new Jugador(null, req.fullName(), req.position(), req.jerseyNumber(), req.equipoId()));
    }

    @PutMapping("/{id}")
    public Mono<Jugador> update(@PathVariable Integer id, @RequestBody @Valid JugadorRequests.Update req) {
        return service.update(id, new Jugador(null, req.fullName(), req.position(), req.jerseyNumber(), req.equipoId()));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Integer id) { return service.delete(id); }
}

