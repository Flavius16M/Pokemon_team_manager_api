package com.PokemonManager.pokemon_team_manager.exception;

public class PokemonNoEncontradoException extends RuntimeException {

    public PokemonNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}