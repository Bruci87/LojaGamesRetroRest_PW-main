package com.ufrn.lojagamesretro.core.exception;

public class CategoriaNotFoundException extends Exception {
    String message;

    public CategoriaNotFoundException(String message) {
        this.message = message;
    }
}
