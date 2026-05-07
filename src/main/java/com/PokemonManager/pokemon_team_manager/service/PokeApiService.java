package com.PokemonManager.pokemon_team_manager.service;

import org.springframework.stereotype.Service;
import com.PokemonManager.pokemon_team_manager.dto.PokemonDTO;

@Service
public class PokeApiService {

    public PokemonDTO obtenerPokemonPorNombre(String nombre) {

        // TEMPORAL (simulación para que no falle)
        PokemonDTO dto = new PokemonDTO();
        dto.setId(25);
        dto.setNombre(nombre);

        return dto;
    }
}