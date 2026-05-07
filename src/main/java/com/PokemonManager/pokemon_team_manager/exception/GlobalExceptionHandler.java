package com.PokemonManager.pokemon_team_manager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PokemonNoEncontradoException.class)
    public ResponseEntity<String> manejarPokemonNoEncontrado(PokemonNoEncontradoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EquipoLlenoException.class)
    public ResponseEntity<String> manejarEquipoLleno(EquipoLlenoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntrenadorNoEncontradoException.class)
    public ResponseEntity<String> manejarEntrenadorNoEncontrado(EntrenadorNoEncontradoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}