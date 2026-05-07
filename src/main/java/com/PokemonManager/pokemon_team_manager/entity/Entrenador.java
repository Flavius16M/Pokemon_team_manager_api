package com.PokemonManager.pokemon_team_manager.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity

public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "entrenador", cascade = CascadeType.ALL)
    private List<Pokemon> pokemons = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public boolean puedeCapturarPokemon() {
        return this.pokemons.size() < 6;
    }

    public void agregarPokemon(Pokemon pokemon) {
        if (puedeCapturarPokemon()) {
            pokemons.add(pokemon);
            pokemon.setEntrenador(this);
        } else {
            throw new RuntimeException("El entrenador ya tiene 6 Pokémon");
        }
    }

    
    
}
