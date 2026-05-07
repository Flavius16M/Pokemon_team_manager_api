package com.PokemonManager.pokemon_team_manager.service;

import org.springframework.stereotype.Service;

import com.PokemonManager.pokemon_team_manager.dto.PokemonDTO;
import com.PokemonManager.pokemon_team_manager.entity.Entrenador;
import com.PokemonManager.pokemon_team_manager.entity.Pokemon;
import com.PokemonManager.pokemon_team_manager.repository.PokemonRepository;

@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;
    private final EntrenadorService entrenadorService;
    private final PokeApiService pokeApiService;

    public PokemonService(PokemonRepository pokemonRepository, EntrenadorService entrenadorService, PokeApiService pokeApiService) {
        this.pokemonRepository = pokemonRepository;
        this.entrenadorService = entrenadorService;
        this.pokeApiService = pokeApiService;
    }

    public Pokemon capturarPokemon(String nombre, Long entrenadorId) {
        Entrenador entrenador = entrenadorService.obtenerPorId(entrenadorId);
        if (!entrenador.puedeCapturarPokemon()) {
            throw new RuntimeException("El entrenador ya tiene 6 Pokémon");
        }

        PokemonDTO dto = pokeApiService.obtenerPokemonPorNombre(nombre);
        Pokemon pokemon = new Pokemon();
        pokemon.setPokeApiId(dto.getId());
        pokemon.setNombre(dto.getNombre());
        pokemon.setEntrenador(entrenador);
        return pokemonRepository.save(pokemon);
        
        
    }

    
     

    
}
