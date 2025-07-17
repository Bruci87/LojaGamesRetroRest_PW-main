package com.ufrn.lojagamesretro.core.errorhandling;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.ufrn.lojagamesretro.core.exception.CategoriaNotFoundException;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(ConstraintViolationException.class)
    ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException e) {
        Map<String, Object> body = new LinkedHashMap<>();

        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Ocorreram violações de restrição no cadastro.");


        for (var c : e.getConstraintViolations()) {
            // A partir daqui, e SÓ AQUI DENTRO, o Java sabe quem é 'c'.
            body.put(c.getPropertyPath().toString(), c.getMessage());
        }



        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CategoriaNotFoundException.class)
    public ResponseEntity<Object> handleCategoriaNotFoundException(CategoriaNotFoundException ex) { // <--- CORRIGIDO
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Erro ao aceder ao recurso.");
        body.put("error", ex.getMessage()); // Agora usa a mensagem da exceção correta
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }


}