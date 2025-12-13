package com.fiap.res.exceptions;

import org.springframework.http.HttpStatus;

public class RestaurantAlreadyExistsException extends BaseBusinessException {
    public RestaurantAlreadyExistsException() {
        super("Restaurante ja existe", "Erro de validação", HttpStatus.BAD_REQUEST);
    }
}
