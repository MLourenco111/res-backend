package com.fiap.res;

import com.fiap.res.exceptions.InvalidRestaurantException;

public enum CuisineType {
    ITALIAN,
    BRAZILIAN,
    JAPANESE,
    MEXICAN;

    public static CuisineType fromString(String value) {
        if (value == null) return null;
        try {
            return CuisineType.valueOf(value.trim().toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new InvalidRestaurantException("Tipo de cozinha inválido: " + value);
        }
    }
}
