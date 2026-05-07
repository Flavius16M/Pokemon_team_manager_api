package com.PokemonManager.pokemon_team_manager.dto;

public class PokemonResponseDTO {

    private Long id;
    private String nombre;

    public PokemonResponseDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
}