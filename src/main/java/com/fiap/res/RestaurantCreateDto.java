package com.fiap.res;

import java.time.LocalTime;

public record RestaurantCreateDto(
        String name,
        CuisineType cuisineType,
        LocalTime openingTime,
        LocalTime closingTime,
        String taxId,
        String branchCode,
        Long ownerId,
        String street,
        String number,
        String city,
        String state,
        String country,
        String zipCode) {
}
