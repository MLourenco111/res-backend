package com.fiap.res;

import org.springframework.http.HttpStatus;

import java.util.List;

public class RestaurantAlreadyExistsException extends BaseBusinessException {
    public RestaurantAlreadyExistsException() {
        super("Restaurante ja existe", "Erro de validação", HttpStatus.BAD_REQUEST);
    }
}
