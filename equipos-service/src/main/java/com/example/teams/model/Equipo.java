package com.example.teams.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("equipos")
public record Equipo(
        @Id Integer id,
        String name,
        String city,
        String conference,
        Integer championships
) {}

