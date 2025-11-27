package com.fiap.res.usecase;

import com.fiap.res.RestaurantCreateDto;
import com.fiap.res.domain.Restaurant;

public class RestaurantCreate {

    public Long persist(RestaurantCreateDto dto){
            Long id = null;
            Restaurant restaurant = new Restaurant();
            restaurant.giveName(dto.name());
            restaurant.linkOwner(dto.ownerId());
            restaurant.defineWorkingHours(dto.openingTime(),dto.closingTime());
            //definir tipo de cozinha
            //adicionar endereco
            //salvar o restaurante

            return id;
    }
}
