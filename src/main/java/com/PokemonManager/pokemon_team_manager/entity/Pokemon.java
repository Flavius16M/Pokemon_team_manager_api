package com.PokemonManager.pokemon_team_manager.entity;

import jakarta.persistence.*;

@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer pokeApiId;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "entrenador_id")
    private Entrenador entrenador;

    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public Integer getPokeApiId() {
        return pokeApiId;
    }

    public void setPokeApiId(Integer pokeApiId) {
        this.pokeApiId = pokeApiId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }
}