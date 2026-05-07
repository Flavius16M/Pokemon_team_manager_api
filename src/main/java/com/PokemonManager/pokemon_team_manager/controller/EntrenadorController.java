package com.PokemonManager.pokemon_team_manager.controller;

import org.springframework.web.bind.annotation.*;

import com.PokemonManager.pokemon_team_manager.dto.EntrenadorResponseDTO;
import com.PokemonManager.pokemon_team_manager.entity.Entrenador;
import com.PokemonManager.pokemon_team_manager.service.EntrenadorService;

@RestController
@RequestMapping("/entrenadores")
public class EntrenadorController {

    private final EntrenadorService entrenadorService;

    public EntrenadorController(EntrenadorService entrenadorService) {
        this.entrenadorService = entrenadorService;
    }

    @GetMapping("/{id}")
    public EntrenadorResponseDTO obtenerPorId(@PathVariable Long id) {

        Entrenador entrenador = entrenadorService.obtenerPorId(id);

        return entrenadorService.convertirADTO(entrenador);
    }
}