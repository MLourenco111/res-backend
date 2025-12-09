package com.fiap.res.usercase;

import com.fiap.res.RestaurantAlreadyExistsException;
import com.fiap.res.RestaurantCreateDto;
import com.fiap.res.StringTransform;
import com.fiap.res.domain.Address;
import com.fiap.res.domain.Restaurant;
import com.fiap.res.interfaces.RestauranteGateway;

public class RestaurantCreateUserCase {

    private RestauranteGateway restauranteGateway;

    public RestaurantCreateUserCase(RestauranteGateway restauranteGateway) {
        this.restauranteGateway = restauranteGateway;
    }

    public Restaurant persist(RestaurantCreateDto dto){
        String taxIdNormalized = StringTransform.NORMALIZE.apply(dto.taxId());
        String branchCodeNormalized = StringTransform.UPPER_TRIM.apply(dto.branchCode());
        if(restauranteGateway.existsByTaxIdAndBranchCode(taxIdNormalized, branchCodeNormalized)){
            throw  new RestaurantAlreadyExistsException();
        }

        //validar se o usuario existe e tem o tipo dono de restaurante lembrando que esta em outro projeto

        final Address address = new Address( null,dto.street(),dto.number(),dto.city(),dto.state(),dto.country(),dto.zipCode());
        final Restaurant restaurant = Restaurant.create(dto.name(),taxIdNormalized,branchCodeNormalized,
                dto.cuisineType(),dto.openingTime(),dto.closingTime(),dto.ownerId(),address);

        return restauranteGateway.save(restaurant);

    }
}
