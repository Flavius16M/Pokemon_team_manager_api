package com.PokemonManager.pokemon_team_manager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.PokemonManager.pokemon_team_manager.entity.Pokemon;
import com.PokemonManager.pokemon_team_manager.service.PokemonService;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @PostMapping("/capturar")
    public Pokemon capturarPokemon(
            @RequestParam String nombre,
            @RequestParam Long entrenadorId) {

        return pokemonService.capturarPokemon(nombre, entrenadorId);

        
        
    }
    @GetMapping("/entrenador/{id}")
     public List<Pokemon> obtenerPokemonsDeEntrenador1(@PathVariable Long id) {

    return pokemonService.obtenerPokemonsDeEntrenador(id);
}
}