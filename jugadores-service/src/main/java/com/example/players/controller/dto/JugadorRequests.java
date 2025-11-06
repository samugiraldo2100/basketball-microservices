package com.example.players.controller.dto;

import jakarta.validation.constraints.NotBlank;

public class JugadorRequests {
    public record Create(@NotBlank String fullName,
                         @NotBlank String position,
                         Integer jerseyNumber,
                         Integer equipoId) {}
    public record Update(@NotBlank String fullName,
                         @NotBlank String position,
                         Integer jerseyNumber,
                         Integer equipoId) {}
}

