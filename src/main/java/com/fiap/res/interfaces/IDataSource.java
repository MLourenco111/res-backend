package com.fiap.res.interfaces;

import com.fiap.res.OwnerDto;
import com.fiap.res.RestaurantCreateDto;
import com.fiap.res.RestaurantDto;

public interface IDataSource {
    boolean existsByTaxIdAndBranchCode(String taxId, String branchCode);

    RestaurantDto persist(RestaurantCreateDto restaurantCreateDto);

    OwnerDto findById(Long idOwner);
}
