package com.PokemonManager.pokemon_team_manager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.PokemonManager.pokemon_team_manager.dto.EntrenadorResponseDTO;
import com.PokemonManager.pokemon_team_manager.dto.PokemonResponseDTO;
import com.PokemonManager.pokemon_team_manager.entity.Entrenador;
import com.PokemonManager.pokemon_team_manager.exception.EntrenadorNoEncontradoException;
import com.PokemonManager.pokemon_team_manager.repository.EntrenadorRepository;

@Service
public class EntrenadorService {

    private final EntrenadorRepository entrenadorRepository;

    public EntrenadorService(EntrenadorRepository entrenadorRepository) {
        this.entrenadorRepository = entrenadorRepository;
    }

    public Entrenador crearEntrenador(String nombre) {
        Entrenador entrenador = new Entrenador();
        entrenador.setNombre(nombre);
        return entrenadorRepository.save(entrenador);
    }

    public List<Entrenador> obtenerTodosLosEntrenadores() {
        return entrenadorRepository.findAll();
    }

    public Entrenador obtenerPorId(Long id) {
        return entrenadorRepository.findById(id).orElseThrow(() -> new EntrenadorNoEncontradoException("Entrenador no encontrado"));
    }

    public EntrenadorResponseDTO convertirADTO(Entrenador entrenador) {

    List<PokemonResponseDTO> pokemons = entrenador.getPokemons()
        .stream()
        .map(p -> new PokemonResponseDTO(p.getId(), p.getNombre()))
        .toList();

    return new EntrenadorResponseDTO(
        entrenador.getId(),
        entrenador.getNombre(),
        pokemons
    );
}
   
}
    

