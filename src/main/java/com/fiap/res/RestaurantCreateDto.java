package com.fiap.res;

import java.time.LocalTime;

public record RestaurantCreateDto(
        String name,
        String cuisineType,
        LocalTime openingTime,
        LocalTime closingTime,
        Long ownerId,
        String street,
        String number,
        String city,
        String state,
        String country,
        String zipCode) {
}
