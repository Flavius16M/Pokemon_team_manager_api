package com.PokemonManager.pokemon_team_manager.service;

import java.util.List;

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

    public List<Pokemon> obtenerPokemonsDeEntrenador(Long entrenadorId) {

    Entrenador entrenador = entrenadorService.obtenerPorId(entrenadorId);

    return entrenador.getPokemons();
}
    public void liberarPokemon(Long entrenadorId, Long pokemonId) {

    //comprobar entrenador
    Entrenador entrenador = entrenadorService.obtenerPorId(entrenadorId);

    //buscar pokemon
    Pokemon pokemon = pokemonRepository.findById(pokemonId)
            .orElseThrow(() -> new RuntimeException("Pokemon no encontrado"));

    //comprobar que pertenece al entrenador
    if (!pokemon.getEntrenador().getId().equals(entrenador.getId())) {
        throw new RuntimeException("Este pokemon no pertenece al entrenador");
    }

    //borrar pokemon
    pokemonRepository.delete(pokemon);
}
     

    
}
