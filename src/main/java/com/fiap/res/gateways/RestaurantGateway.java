package com.fiap.res.gateways;

import com.fiap.res.RestaurantCreateDto;
import com.fiap.res.RestaurantDto;
import com.fiap.res.domains.Restaurant;
import com.fiap.res.interfaces.IDataSource;
import com.fiap.res.interfaces.IRestauranteGateway;

public class RestaurantGateway implements IRestauranteGateway {

    private final IDataSource dataSource;

    public RestaurantGateway(IDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static  RestaurantGateway create (IDataSource dataSource){
        return  new RestaurantGateway(dataSource);
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        final RestaurantCreateDto restaurantCreateDto = new RestaurantCreateDto(
                restaurant.getName(),
                restaurant.getCuisineType(),
                restaurant.getOpeningTime(),
                restaurant.getClosingTime(),
                restaurant.getTaxId(),
                restaurant.getBranchCode(),
                restaurant.getOwner().getId(),
                restaurant.getAddress().getStreet(),
                restaurant.getAddress().getNumber(),
                restaurant.getAddress().getCity(),
                restaurant.getAddress().getState(),
                restaurant.getAddress().getCity(),
                restaurant.getAddress().getZipCode()
        );
        final RestaurantDto restaurantPersisted = this.dataSource.persist(restaurantCreateDto);
        //return Restaurant.create(null);
        return null;
    }

    @Override
    public boolean existsByTaxIdAndBranchCode(String taxId, String branchCode) {
        return this.dataSource.existsByTaxIdAndBranchCode(taxId, branchCode);
    }
}
