package com.fiap.res.usercases;

import com.fiap.res.domains.Owner;
import com.fiap.res.exceptions.RestaurantAlreadyExistsException;
import com.fiap.res.RestaurantCreateDto;
import com.fiap.res.StringTransform;
import com.fiap.res.domains.Address;
import com.fiap.res.domains.Restaurant;
import com.fiap.res.interfaces.IOwnerGateway;
import com.fiap.res.interfaces.IRestauranteGateway;

import java.util.Optional;

public class RestaurantCreateUserCase {

    private IRestauranteGateway restauranteGateway;
    private IOwnerGateway ownerGateway;

    public RestaurantCreateUserCase(IRestauranteGateway restauranteGateway, IOwnerGateway ownerGateway) {
        this.restauranteGateway = restauranteGateway;
        this.ownerGateway = ownerGateway;
    }

    public static RestaurantCreateUserCase create(IRestauranteGateway restaurantGateway,IOwnerGateway ownerGateway) {
        return new RestaurantCreateUserCase(restaurantGateway, ownerGateway);
    }

    public Restaurant persist(RestaurantCreateDto dto){
        String taxIdNormalized = StringTransform.NORMALIZE.apply(dto.taxId());
        String branchCodeNormalized = StringTransform.UPPER_TRIM.apply(dto.branchCode());
        if(restauranteGateway.existsByTaxIdAndBranchCode(taxIdNormalized, branchCodeNormalized)){
            throw new RestaurantAlreadyExistsException();
        }

        final Owner owner = ownerGateway.findById(dto.ownerId()).orElseThrow(() ->  new RuntimeException("implementar exception personalizada"));
        if(!owner.getTypes().contains("RESTAURANT_OWNER")){
            throw  new RuntimeException("implementar exception personalizada");
        }

        final Address address = new Address( null,dto.street(),dto.number(),dto.city(),dto.state(),dto.country(),dto.zipCode());
        final Restaurant restaurant = Restaurant.create(
                dto.name(),
                taxIdNormalized,
                branchCodeNormalized,
                dto.cuisineType(),
                dto.openingTime(),dto.closingTime(),
                owner,
                address);

        return restauranteGateway.save(restaurant);
    }
}
