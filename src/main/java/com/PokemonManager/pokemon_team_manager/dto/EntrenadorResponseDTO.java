package com.PokemonManager.pokemon_team_manager.dto;

import java.util.List;

public class EntrenadorResponseDTO {

    private Long id;
    private String nombre;
    private List<PokemonResponseDTO> pokemons;

    public EntrenadorResponseDTO(Long id, String nombre, List<PokemonResponseDTO> pokemons) {
        this.id = id;
        this.nombre = nombre;
        this.pokemons = pokemons;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public List<PokemonResponseDTO> getPokemons() { return pokemons; }
}