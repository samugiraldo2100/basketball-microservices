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



