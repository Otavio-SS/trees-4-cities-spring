package br.com.trees4cities.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Nenhum plantio encontrado para este CPF.")
public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super();
    }
}