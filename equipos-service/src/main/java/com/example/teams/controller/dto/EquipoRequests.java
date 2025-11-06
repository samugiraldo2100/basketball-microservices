package com.example.teams.controller.dto;

import jakarta.validation.constraints.NotBlank;

public class EquipoRequests {
    public record Create(@NotBlank String name,
                        @NotBlank String city,
                        @NotBlank String conference,
                        Integer championships) {}
    public record Update(@NotBlank String name,
                        @NotBlank String city,
                        @NotBlank String conference,
                        Integer championships) {}
}
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

