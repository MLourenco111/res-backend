package com.fiap.res;

import org.springframework.http.HttpStatus;

import java.util.List;

public class InvalidRestaurantException extends BaseBusinessException {
    public InvalidRestaurantException(List<String> errorCodes) {
        super(errorCodes, "Erro de validação", HttpStatus.BAD_REQUEST);
    }

    public InvalidRestaurantException(String errorCode) {
        super(errorCode, "Erro de validação", HttpStatus.BAD_REQUEST);
    }
    }
