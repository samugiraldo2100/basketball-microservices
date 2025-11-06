package com.example.players.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("jugadores")
public record Jugador(
        @Id Integer id,
        String fullName,
        String position,
        Integer jerseyNumber,
        Integer equipoId
) {}

