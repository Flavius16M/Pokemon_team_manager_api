package com.PokemonManager.pokemon_team_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PokemonManager.pokemon_team_manager.entity.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    
}
